import java.io.*;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;

public class RSA extends AsymmetricEncDec{
	/* RSA accepts numbers >= 512 and 
	 * requires to be multiples of 8 bits => binary bits (512=2^9, 1024=2^10, 2048=2^11, etc.)
	 * 
	 * It can work even without the binary bits (e.g. 2500) but can cause compatibility issues
	 */
	private static final int RSA_key_size = 2048; // Minimum Recommended
	private static final int CHUNK_size = (RSA_key_size/8) - 11;// Max chunk size for encryption with padding
	// Create Key-Pair
	public KeyPair generateKeyPair() throws Exception {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(RSA_key_size);
		return keyGen.generateKeyPair();
	}
	@Override
	public void encryptFile(String input, String output, PublicKey pk) throws Exception {
		// TODO Auto-generated method stub
		// Read file as bytes
		// byte[] data = super.readFile(input);
		try(FileInputStream fis = new FileInputStream(input);
			FileOutputStream fos = new FileOutputStream(output)){
			
			byte[] buffer = new byte[CHUNK_size];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				// Trim a byte data to buffer CHUNK_size
				byte[] data = bytesRead == buffer.length ? buffer: trimByteArray(buffer, bytesRead);
				//Encrypt Data as chunk
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, pk);
				byte[] encryptedData = cipher.doFinal(data);
				// Write the encrypted data(chunk) with Base64 encoding for portability
				fos.write(Base64.getEncoder().encode(encryptedData));
				fos.write('\n'); // Add a newline for data (chunk) separation
			}
		}
		// Write encrypted file 
		//super.writeFile(output, encryptedData);
	}
	// Utility method to trim a byte array to the specified length
	private static byte[] trimByteArray(byte[] array, int length) {
		// TODO Auto-generated method stub
		byte[] trimmed = new byte[length];
		System.arraycopy(array, 0, trimmed, 0, length);
		return trimmed;
	}
	@Override
	public void decryptFile(String encrypted, String output, PrivateKey pk) throws Exception {
		// TODO Auto-generated method stub
		// Read file as bytes
		// byte[] encryptedData = super.readFile(input);
		try(BufferedReader br = new BufferedReader(new FileReader(encrypted));
			FileOutputStream fos = new FileOutputStream(output)) {
			
			String line;
			while((line = br.readLine()) != null) {
				// Decrypt the encrypted data (chunk)
				byte[] encryptedChunk = Base64.getDecoder().decode(line);
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, pk);
				byte[] decryptedData = cipher.doFinal(encryptedChunk);
                // Write the decrypted data to the output file
				fos.write(decryptedData);
			}
		}
		// Write decrypted file
		//super.writeFile(output, decryptedData);
	}
}
