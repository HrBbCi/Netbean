package mahoaMD5;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AESV2 {

    String key = "Bar12345Bar12345";
    Key aesKey;
    Cipher cipher;
    byte[] encrypted;
    byte[] deencrypted;

    public AESV2() throws NoSuchAlgorithmException, NoSuchPaddingException {
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher = Cipher.getInstance("AES");
    }

    public String encrypt(String text) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        encrypted = cipher.doFinal(text.getBytes());
        return new String(encrypted);
    }

    public String decrypt(String encodetext) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return new String(cipher.doFinal(encodetext.getBytes()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        AESV2 a = new AESV2();
        String en = a.encrypt("hello");
        System.out.println(en);
        String k = a.decrypt(en);
        System.out.println(k);
    }
}
