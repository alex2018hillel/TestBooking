package prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App2 {

        public static String getDb(String key) {

        FileInputStream fis;
        Properties prop = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/properties");
            prop.load(fis);

        } catch (IOException e) {
            System.err.println("ERROR! File not found!");
        }
        return prop.getProperty(key);
    }
}
