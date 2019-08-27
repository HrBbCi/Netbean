


import java.security.MessageDigest;

public class MD5 {

  public MD5() {
  }

  public String hexStringFromBytes(byte[] b) {
    char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    String hex = "";
    int msb;
    int lsb = 0;
    int i;

    for (i = 0; i < b.length; i++) {
      msb = ((int) b[i] & 0x000000FF) / 16;
      lsb = ((int) b[i] & 0x000000FF) % 16;
      hex = hex + hexChars[msb] + hexChars[lsb];
    }
    return hex;
  }

  public String testMD5(String pass) throws Exception {
    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
    // get md5 for word "PASSWORD"
    digest.update(pass.getBytes());
    byte[] passwordBytes = digest.digest();
    // result = 319f4d26e3c536b5dd871bb2c52e3178
    return hexStringFromBytes(passwordBytes);
  }
}
