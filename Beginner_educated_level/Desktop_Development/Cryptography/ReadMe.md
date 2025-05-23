## Cryptography Module
This code executes/provide execute **cryptographic** to securely **encrypt** and **decrypt** information.

## Features
- Simple, easy-to-use encryption-decryption functions
- Based on proven cryptographic algorithms (RSA,DES,etc.)
- Distinguished as symmetric and asymmetric cryptography
- The information is saved and stored in cryptographic files(.txt,...)

## Usage
```java
import java.security.*; --> KeyPair<Public,Private>
import javax.crypto.*; --> SecretKey
import java.util.Base64; --> Base64.getEncoder()

Add External Archive(Library): bcprov-jdk18on-1.79.jar
This jar contains the JCA/JCE provider and low-level API for the BC Java
