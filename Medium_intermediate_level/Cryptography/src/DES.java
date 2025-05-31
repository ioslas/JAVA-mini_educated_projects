import java.io.*;
import java.nio.file.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DES extends SymmetricEncDec {
	// DES keysize=56 only
	private static final int DES_key_size = 56;
	// Create Key
	public void generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(DES_key_size);
		super.sk=keyGen.generateKey();
	}
	// Load an existing key (if needed)
	public void loadKey(byte[] keyBytes) {
		super.sk = new SecretKeySpec(keyBytes, "DES");
	}
	public SecretKey getKey() {
		return super.sk;
	}
	@Override
	void encryptFile(String input, String output, SecretKey secret) throws Exception {
		// TODO Auto-generated method stub
		// Same way (the below code) with AES
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, super.sk);
		byte[] inputBytes = Files.readAllBytes(new File(input).toPath());
		byte[] encryptedBytes = cipher.doFinal(inputBytes);
		// Write encrypted data to output file
		try(FileOutputStream outputStream = new FileOutputStream(output)){
			outputStream.write(encryptedBytes);
		}
	}
	@Override
	void decryptFile(String encrypted, String output, SecretKey secret) throws Exception {
		// TODO Auto-generated method stub
		// Same way (the below code) with AES
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, super.sk);
		byte[] inputBytes = Files.readAllBytes(new File(encrypted).toPath());
		byte[] encryptedBytes = cipher.doFinal(inputBytes);
		// Write encrypted data to output file
		try(FileOutputStream outputStream = new FileOutputStream(output)){
			outputStream.write(encryptedBytes);
		}
	}
}
