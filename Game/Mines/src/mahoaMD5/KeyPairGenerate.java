package mahoaMD5;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 *
 * @author giasutinhoc.vn
 */
public class KeyPairGenerate {

    public static void main(String[] args) {
        try {
            SecureRandom sr = new SecureRandom();
            //Thuật toán phát sinh khóa - Rivest Shamir Adleman (RSA)
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048, sr);

            //Phát sinh cặp khóa
            KeyPair kp = kpg.genKeyPair();
            //PublicKey
            PublicKey pubKey = kp.getPublic();
            //PrivateKey
            PrivateKey priKey = kp.getPrivate();

            //Lưu Public Key
            FileOutputStream fos = new FileOutputStream("E:/file/a.txt");
            fos.write(pubKey.getEncoded());
            fos.close();

            //Lưu Private Key
            fos = new FileOutputStream("E:/file/b.txt");
            fos.write(priKey.getEncoded());
            fos.close();

            System.out.println("Generate key successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
