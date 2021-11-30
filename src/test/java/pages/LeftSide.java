package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LeftSide {

    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nameProjectTxtBox= new TextBox(By.id("NewProjNameInput"));
    public Button addButton= new Button(By.id("NewProjNameButton"));
    public Label projectName;

    public LeftSide(){}

    public boolean isDisplayedProject(String nameProj){
        projectName= new Label(By.xpath("//table[@class='ProjItemTable']//td[text()='"+nameProj+"']"));
        return  projectName.isDisplayedControl();
    }


}
