package com.base.encrypt.aes;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 这个是aes加密
 * @author gbq
 */
public class AES {
	// 加密    
    public static String Encrypt(String sSrc, String sKey) throws Exception {    
        if (sKey == null) {    
            System.out.print("Key为空null");    
            return null;    
        }    
        // 判断Key是否为16位    
        if (sKey.length() != 16) {    
            System.out.print("Key长度不是16位");    
            return null;    
        }    
        byte[] raw = sKey.getBytes();    
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");    
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"    
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度    
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);    
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());    
    
        return Base64Utils.encodeToString(encrypted);//此处使用BAES64做转码功能，同时能起到2次加密的作用。    
    }    
    
    // 解密    
    public static String Decrypt(String sSrc, String sKey) throws Exception {    
        try {    
            // 判断Key是否正确    
            if (sKey == null) {    
                System.out.print("Key为空null");    
                return null;    
            }    
            // 判断Key是否为16位    
            if (sKey.length() != 16) {    
                System.out.print("Key长度不是16位");    
                return null;    
            }    
            byte[] raw = sKey.getBytes("ASCII");    
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");    
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");    
            IvParameterSpec iv = new IvParameterSpec("0102030405060708"    
                    .getBytes());    
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);    
            byte[] encrypted1 = Base64Utils.decodeFromString(sSrc);//先用bAES64解密    
            try {    
                byte[] original = cipher.doFinal(encrypted1);
                return new String(original);
            } catch (Exception e) {    
                System.out.println(e.toString());    
                return null;    
            }    
        } catch (Exception ex) {    
            System.out.println(ex.toString());    
            return null;    
        }    
    }    
}
