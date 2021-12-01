package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LeftSide {

    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"),"add New Project Button Left Side");
    public TextBox nameProjectTxtBox= new TextBox(By.id("NewProjNameInput"),"name TextBox Left Side");
    public Button addButton= new Button(By.id("NewProjNameButton"),"add Button Left Side");
    public Label projectName;

    public LeftSide(){}

    public boolean isDisplayedProject(String nameProj){
        projectName= new Label(By.xpath("//table[@class='ProjItemTable']//td[text()='"+nameProj+"']"),"name project label in Left Side");
        return  projectName.isDisplayedControl();
    }


}
