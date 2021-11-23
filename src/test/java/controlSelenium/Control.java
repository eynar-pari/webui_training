package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator) {
        this.locator = locator;
    }

    protected void findControl() {
        this.control = Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click() {
        this.findControl();
        this.control.click();
    }

    public boolean isDisplayedControl() {
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public String getTextControl(){
        this.findControl();
        return this.control.getText();
    }


}
