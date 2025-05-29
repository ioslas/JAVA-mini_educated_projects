import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AES extends SymmetricEncDec {
	// AES keysize must be equal to 128, 192 or 
	// 256 => high security
	private static final int AES_key_size = 256;
	// Create Key
	public void generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(AES_key_size);
		super.sk=keyGen.generateKey();
	}
	// Load an existing key (if needed)
	public void loadKey(byte[] keyBytes) {
		super.sk = new SecretKeySpec(keyBytes, "AES");
	}
	public SecretKey getKey() {
		return super.sk;
	}
	@Override
	public void encryptFile(String input, String output, SecretKey secret) throws Exception {
		// TODO Auto-generated method stub
		// Cipher mode crucial for encryption
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, super.sk);
		// Read the entire input file into a byte array
		byte[] inputBytes = Files.readAllBytes(new File(input).toPath());
		byte[] encryptedBytes = cipher.doFinal(inputBytes);
		// Write encrypted data to output file
		try(FileOutputStream outputStream = new FileOutputStream(output)){
			outputStream.write(encryptedBytes);
		}
	}
	@Override
	public void decryptFile(String encrypted, String output, SecretKey secret) throws Exception {
		// TODO Auto-generated method stub
		// Cipher mode crucial for decryption
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, super.sk);
		// Read the entire file into a byte array
		byte[] inputBytes = Files.readAllBytes(new File(encrypted).toPath());
		byte[] encryptedBytes = cipher.doFinal(inputBytes);
		// Write encrypted data to output file
		try(FileOutputStream outputStream = new FileOutputStream(output)){
			outputStream.write(encryptedBytes);
		}
	}
}
