## Cryptography Module
This java module provides simple and secure **encryption and decryption** of data using both symmetric and asymmetric cryptography.

## Features
- Simple, easy-to-use Encryption-Decryption functions
- Based on proven cryptographic algorithms: **RSA**, **DES**, etc.
- Supports both **symmetric** and **asymmetric** cryptographic algorithms
- The data information is saved and stored in cryptographic files(.txt, .aes, ...)
- Uses `input.txt` to read the original plain message

##  Technologies used
# Packages (import)
- `java.security.*` --> KeyPair<Public,Private>
- `javax.crypto.*` --> SecretKey
- `java.util.Base64` --> Base64.getEncoder()

# External Libraries
- **bcprov-jdk18on-1.79.jar**: [Source: Bouncy Castle](https://www.bouncycastle.org/)

## Usage
```java
