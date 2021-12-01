package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public static String host;
    public static String user;
    public static String pwd;
    public static String browser;
    public void getProperties() throws IOException {

        Properties properties = new Properties();
        String nameFile = "qa.properties";

        InputStream inputStream= getClass().getClassLoader().getResourceAsStream(nameFile);

        if (inputStream != null)
            properties.load(inputStream);

        user=properties.getProperty("user");
        pwd=properties.getProperty("pwd");
        host=properties.getProperty("host");
        browser=properties.getProperty("browser");

    }
}
