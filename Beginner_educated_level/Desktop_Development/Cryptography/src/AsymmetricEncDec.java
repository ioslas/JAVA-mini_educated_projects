//import java.io.*;
//import java.nio.file.*;
import java.security.*;
import javax.crypto.*;

abstract class AsymmetricEncDec {
	// Same with SymmetricEncDec
	protected SecretKey sk;
	// Only difference: asymmetric needs key-pair
	abstract KeyPair generateKeyPair() throws Exception;
	// File cryptography
	abstract void encryptFile(String input, String output, PublicKey pk) throws Exception;
	abstract void decryptFile(String encrypted, String output, PrivateKey pk) throws Exception;
	/*
	* Read file
	public static byte[] readFile(String filePath) throws IOException {
		return Files.readAllBytes(new File(filePath).toPath());
	}
	* Write file
	public static void writeFile(String filePath, byte[] encyptedData) throws IOException {
		try(FileOutputStream outputStream = new FileOutputStream(filePath)) {
			outputStream.write(encyptedData);
		}	
	} */
}
