package mahoaMD5;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

/**
 *
 * @author giasutinhoc.vn
 */
public class Decryption {

 public static void main(String[] args) {
  try {
   // Đọc file chứa private key
   FileInputStream fis = new FileInputStream("E:/file/b.txt");
   byte[] b = new byte[fis.available()];
   fis.read(b);
   fis.close();
 
   // Tạo private key
   PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
   KeyFactory factory = KeyFactory.getInstance("RSA");
   PrivateKey priKey = factory.generatePrivate(spec);

   // Giải mã dữ liệu
   Cipher c = Cipher.getInstance("RSA");
   c.init(Cipher.DECRYPT_MODE, priKey);
   byte decryptOut[] = c.doFinal(Base64.decode(""
           + "Lug2GToPwgWgkjC+BI0D5hbQcFBP+9/NZ05OwtYSqou/wjuSCfk35K3bODQJkQVLV7uKkpeO4HTGZckT8+BQ9W8v+EXzMJpfXe848FktDuDBvo7yKSn52p6HumLO0WnUgXimtNpTrm+dGyVZQ0kNZKz67HGFmEig5tCQ/y/EQgkqhmUWlLlZQGq8VW/CckIACWdOV+sU3W1i8TjgqusfznrKuvgQ0KSZpIY0KIu+j/e2rh6cpO/OIyARJzfodGmB5TehpDWtJnyBSmR05KRWyMCWFG0BwCcIAEX4jPnzJsKVVKfAXOsA8zxBLnLobWfYr77aUX61RHAgOi+Tu2Jj/g=="));
   System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
  } catch (Exception ex) {
   ex.printStackTrace();
  }
 }
}