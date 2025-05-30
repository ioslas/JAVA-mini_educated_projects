import java.security.*;
import java.util.*;

public class EncryptionDecryption {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SymmetricCryptography
		System.out.println("Cryptography with Symmetric algorithms\n");
		try {
			// AES: Advanced Encryption Standard
			SymmetricEncDec aes= new AES();
			aes.generateKey();
			System.out.println("AES Key: "+ Base64.getEncoder().encodeToString(aes.getKey().getEncoded()));
			//Files
			String inputFile = "input.txt";
			String encryptedFile = "encryptedAES.aes";
			String decryptedFile = "decryptedAES.txt";
			// File Encryption
			aes.encryptFile(inputFile, encryptedFile, aes.getKey());
			System.out.println("File encrypted successfully!");
			// File Decryption
			aes.decryptFile(encryptedFile, decryptedFile, aes.getKey());
			System.out.println("File decrypted successfully!\n");
			//DES: Data Encryption Standard
			SymmetricEncDec des= new DES();
			des.generateKey();
			System.out.println("DES Key: "+ Base64.getEncoder().encodeToString(des.getKey().getEncoded()));
			String encryptedF = "encryptedDES.des";
			String decryptedF = "decryptedDES.txt";
			// File Encryption
			aes.encryptFile(inputFile, encryptedF, des.getKey());
			System.out.println("File encrypted successfully!");
			// File Decryption
			aes.decryptFile(encryptedF, decryptedF, des.getKey());
			System.out.println("File decrypted successfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		//AsymmetricCryptography
		try {
			// Private keys must remain secret, so not printed 
			// RSA (Rivest–Shamir–Adleman)
			AsymmetricEncDec rsa= new RSA();
			KeyPair kp = rsa.generateKeyPair();
			System.out.println("RSA Public Key: "+ Base64.getEncoder().encodeToString(kp.getPublic().getEncoded()));
			//Files
			String inputFile = "input.txt";
			String encryptedFile = "encryptedRSA.rsa";
			String decryptedFile = "decryptedRSA.txt";
			// File Encryption
			rsa.encryptFile(inputFile, encryptedFile, kp.getPublic());
			System.out.println("File encrypted successfully!");
			// File Decryption
			rsa.decryptFile(encryptedFile, decryptedFile, kp.getPrivate());
			System.out.println("File decrypted successfully!\n");
			//ECC: Elliptic-Curve Cryptography
			AsymmetricEncDec ecc= new ECC();
			KeyPair ekp = ecc.generateKeyPair();
			System.out.println("ECC Public Key: "+ Base64.getEncoder().encodeToString(ekp.getPublic().getEncoded()));
			String encryptedF = "encryptedECC.txt";
			String decryptedF = "decryptedECC.txt";
			// File Encryption
			ecc.encryptFile(inputFile, encryptedF, ekp.getPublic());
			System.out.println("File encrypted successfully!");
			// File Decryption
			ecc.decryptFile(encryptedF, decryptedF, ekp.getPrivate());
			System.out.println("File decrypted successfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
