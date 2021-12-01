package controlSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

public class Control {
    protected By locator;
    protected WebElement control;
    protected String myNameControl;

    public Control(By locator,String myNameControl) {
        this.locator = locator;
        this.myNameControl=myNameControl;
    }


    protected void findControl() {
        this.control = Session.getInstance().getDriver().findElement(this.locator);

    }

    @Step("{0}")
    public void stepReport(String action){}


    public void waitControlValueElement(String value){
        this.control = Session.getInstance().getDriver().findElement(this.locator);
        WebDriverWait explictWait= new WebDriverWait(Session.getInstance().getDriver(),15);
        // condition
        explictWait.until(ExpectedConditions.textToBe(this.locator,value));
    }

    public void click() {
        this.stepReport("Click on"+ this.myNameControl);
        this.findControl();
        this.control.click();
    }

    public boolean isDisplayedControl() {
        try {
            this.findControl();
            this.stepReport("Is displayed the "+ this.myNameControl+"? "+this.control.isDisplayed());
            return this.control.isDisplayed();
        } catch (Exception e) {
            this.stepReport("Is displayed the "+ this.myNameControl+"? false");
            return false;
        }
    }


    public String getTextControl(){
        this.findControl();
        this.stepReport("Get text of"+ this.myNameControl+" : "+this.control.getText());
        return this.control.getText();
    }


}
