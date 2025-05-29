# Java Cryptography
## Module
This Java module provides simple and secure **encryption and decryption** of data information using both **symmetric and asymmetric** cryptography.

## Features
- Simple, easy-to-use **encryption-decryption** functions
- Based on proven, well-known cryptographic algorithms (**RSA,DES,etc.**)
- The module supports both **symmetric and asymmetric** cryptographic algorithms.
- The information is saved and stored in **cryptographic files**(.txt,.rsa,.aes,...)
- input.txt is the **original plain message**

## Technologies Used
- **packages (import)** <br>
  `java.security.*` --> KeyPair<Public,Private><br>
  `javax.crypto.*` --> SecretKey<br>
  `java.util.Base64` --> Base64.getEncoder()...<br>

- **libraries**<br>
**External Library**: [Source](https://www.bouncycastle.org/)<br>
  - `bcprov-jdk18on-1.79.jar`: must be added to your project as an external archive
