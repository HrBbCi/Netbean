package autoclicker.multilingual;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class PropertiesToBuiltIn {

    public static void main ( String[] args ) throws IOException {
        File file = new File("D:/Desktop/new 3.txt");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(file), "UTF8"));
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String elem = (String)enumeration.nextElement();
            System.out.println("map.put(\""+elem+"\", \""+properties.getProperty(elem, elem).replace("\"", "\\\"")+"\");");
        }
    }

}
