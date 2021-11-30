package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeCloud implements IBrowser {
    public static final String USERNAME = "use your user name";
    public static final String AUTOMATE_KEY = "use your key";
    public static final String URLServer = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Override
    public WebDriver create() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "96.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "training nybblegroup");
        caps.setCapability("name", "Testing 1");

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URLServer), caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
