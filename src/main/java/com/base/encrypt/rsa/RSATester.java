package com.base.encrypt.rsa;

import org.springframework.util.Base64Utils;

import java.util.Map;

public class RSATester {

	static String publicKey;
	static String privateKey;

	static {
		try {
			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			publicKey = RSAUtils.getPublicKey(keyMap);
			privateKey = RSAUtils.getPrivateKey(keyMap);
			System.err.println("公钥: \n\r" + publicKey);
			System.err.println("私钥： \n\r" + privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		test();
	}

	static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String source = "654321";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        String safeWord = Base64Utils.encodeToString(encodedData);
        System.out.println(safeWord);
        byte[] decodedData = RSAUtils.decryptByPrivateKey(Base64Utils.decodeFromString(safeWord), privateKey);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }
}
