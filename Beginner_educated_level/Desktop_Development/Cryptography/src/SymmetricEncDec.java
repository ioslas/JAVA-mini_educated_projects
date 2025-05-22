import javax.crypto.*;

abstract class SymmetricEncDec {
	protected SecretKey sk;
	abstract void generateKey() throws Exception;
	abstract void loadKey(byte[] keyBytes);
	abstract SecretKey getKey();
	abstract void encryptFile(String input, String output, SecretKey secret) throws Exception;
	abstract void decryptFile(String encrypted, String output, SecretKey secret) throws Exception;
}
