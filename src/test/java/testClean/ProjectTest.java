package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Date;

public class ProjectTest extends TestBase{
    MainPage mainPage = new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSide leftSide= new LeftSide();
    CentralSide centralSide= new CentralSide();

    @Test
    public void verifyCreateProject() throws InterruptedException {
        String name= String.valueOf(new Date().getTime());
        mainPage.loginImage.click();
        loginModal.login("training@training2021.com","12345");
        leftSide.addNewProjectButton.click();
        leftSide.nameProjectTxtBox.setText(name);
        leftSide.addButton.click();
        centralSide.projectSelectedLabel.waitControlValueElement(name);
        String expectedResult=name;
        String actualResult=centralSide.projectSelectedLabel.getTextControl();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! project was not created");
    }
}
