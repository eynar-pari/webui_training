package testClean;

import helpers.ReadProperties;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;

import java.io.IOException;

import static helpers.ReadProperties.host;


public class TestBase {

    @BeforeEach
    public void setup() throws IOException {
        new ReadProperties().getProperties();
        Session.getInstance().getDriver().get(host);
    }
    @AfterEach
    public void cleanup(){
       byte[] screenShot = ((TakesScreenshot) Session.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
       this.attachHTML("image", screenShot );
       Session.getInstance().closeSession();
    }
    @Attachment(value="{0}",type="image/png")
    public byte[] attachHTML(String name,byte[]  screenShot){
        return screenShot;
    }

}
