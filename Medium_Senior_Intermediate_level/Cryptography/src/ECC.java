import java.io.*;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ECC extends AsymmetricEncDec{
	// ECC keysize must be at least 112 bits
	// Note: ECC key sizes correspond to specific standardized curves, not arbitrary values
	private static final int ECC_key_size = 224; // Minimum accepted: equivalent security = 112-bit
	private static final int CHUNK_size = (ECC_key_size/8) - 11;// Max chunk size for encryption with padding
	// Create Key-Pair
	public KeyPair generateKeyPair() throws Exception {
		// TODO Auto-generated method stub
		Security.addProvider(new BouncyCastleProvider());
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
		keyGen.initialize(ECC_key_size);
		return keyGen.generateKeyPair();	
	}
	@Override
	public void encryptFile(String input, String output, PublicKey pk) throws Exception {
		// TODO Auto-generated method stub
		// ECC hybrid approach uses AES encryption
		try(FileInputStream fis = new FileInputStream(input);
			FileOutputStream fos = new FileOutputStream(output)){
			
			byte[] buffer = new byte[CHUNK_size];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				// Trim a byte data to buffer CHUNK_size
				byte[] data = bytesRead == buffer.length ? buffer: trimByteArray(buffer, bytesRead);
				//Encrypt Data as chunk
				Cipher cipher = Cipher.getInstance("ECIES");
				cipher.init(Cipher.ENCRYPT_MODE, pk);
				byte[] encryptedData = cipher.doFinal(data);
				// Write the encrypted data(chunk) with Base64 encoding for portability
				fos.write(Base64.getEncoder().encode(encryptedData));
				fos.write('\n'); // Add a newline for data (chunk) separation
			}
		}
	}

	@Override
	public void decryptFile(String encrypted, String output, PrivateKey pk) throws Exception {
		// TODO Auto-generated method stub
		// ECC hybrid approach uses AES encryption
		try(BufferedReader br = new BufferedReader(new FileReader(encrypted));
			FileOutputStream fos = new FileOutputStream(output)) {
			
			String line;
			while((line = br.readLine()) != null) {
				// Decrypt the encrypted data (chunk)
				byte[] encryptedChunk = Base64.getDecoder().decode(line);
				Cipher cipher = Cipher.getInstance("ECIES");
				cipher.init(Cipher.DECRYPT_MODE, pk);
				byte[] decryptedData = cipher.doFinal(encryptedChunk);
                // Write the decrypted data to the output file
				fos.write(decryptedData);
			}
		}
	}
	// Utility method to trim a byte array to the specified length
	private static byte[] trimByteArray(byte[] array, int length) {
		// TODO Auto-generated method stub
		byte[] trimmed = new byte[length];
		System.arraycopy(array, 0, trimmed, 0, length);
		return trimmed;
	}
}
