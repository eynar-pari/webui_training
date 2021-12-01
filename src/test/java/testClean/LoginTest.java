package testClean;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import static helpers.ReadProperties.pwd;
import static helpers.ReadProperties.user;

public class LoginTest  extends TestBase{
    MainPage mainPage = new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection= new MenuSection();

    @Test
    @DisplayName("Verify Login Todo.ly")
    @Description("This test case is to verify the login using the correct credentials")
    @Epic("Login")
    @Feature("Authentication")
    @Link("www.jira.com/Test")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("BUG001")
    public void verifyLoginHappyPath(){
        mainPage.loginImage.click();
        loginModal.emailTextBox.setText(user);
        loginModal.passwordTextBox.setText(pwd);
        loginModal.loginButton.click();

        Assertions.assertTrue(menuSection.logoutLink.isDisplayedControl(),
                 "ERROR! the login was failed");
    }

}
