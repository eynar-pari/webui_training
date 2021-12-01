package pages;

import controlSelenium.Image;
import org.openqa.selenium.By;

public class MainPage {
    public Image loginImage = new Image(By.xpath("//img[@src='/Images/design/pagelogin.png']"),"login image in main page");

    public MainPage(){

    }

}
