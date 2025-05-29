import javax.crypto.*;

abstract class SymmetricEncDec {
	// Key methods
	protected SecretKey sk;
	// Symmetric only needs Key 
	abstract void generateKey() throws Exception;
	abstract void loadKey(byte[] keyBytes);
	abstract SecretKey getKey();
	// File cryptography
	abstract void encryptFile(String input, String output, SecretKey secret) throws Exception;
	abstract void decryptFile(String encrypted, String output, SecretKey secret) throws Exception;
}
