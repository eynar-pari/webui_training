package pages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginModal {
    public TextBox emailTextBox= new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"),"email textbox in login modal");
    public TextBox passwordTextBox= new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"),"pwd textbox in login modal");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"),"login button in login modal");

    public LoginModal(){}

    public void login(String user,String pwd){
        this.emailTextBox.setText(user);
        this.passwordTextBox.setText(pwd);
        this.loginButton.click();
    }

}
