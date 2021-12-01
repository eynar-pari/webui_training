package controlSelenium;

import org.openqa.selenium.By;

public class TextBox extends  Control{


    public TextBox(By locator, String myNameControl) {
        super(locator, myNameControl);
    }

    public void setText(String value){
        this.findControl();
        this.stepReport("Set TextBox "+ this.myNameControl+" with the value "+value);
        this.control.sendKeys(value);
    }

}
