package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.DataEntry;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasicSelenium {
    ChromeDriver driver;
    @BeforeEach
    public void setup(){
        String path=new File("").getAbsolutePath()+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);


        driver = new ChromeDriver();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://todo.ly/");

    }

    @AfterEach
    public void cleanup() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void verifyLogin() throws InterruptedException {
        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("training@training2021.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verificacion
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(),"ERROR!! no se pudo hacer login");

        String nameProject=String.valueOf(new Date().getTime());
        // click add project
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        // set name project
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        //click add
        driver.findElement(By.id("NewProjNameButton")).click();
        // verificacion

        Thread.sleep(2000);
        boolean isDisplayedProject= driver.findElement(By.xpath("//table[@class='ProjItemTable']//td[text()='"+nameProject+"']")).isDisplayed();
        Assertions.assertTrue(isDisplayedProject,"ERROR el project no fue creado");
        //
        String actualResult=driver.findElement(By.id("CurrentProjectTitle")).getText();
        String expectedResult=nameProject;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! el projecto no fue creado");

        //UPDATE
        //select el projecto creado
        driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProject+"'] ")).click();
        // click en el menu del project
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();
        // click Edit

        driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[text()='Edit']")).click();
        // fill new name

        String nameUpdated="Eynar";
        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys(nameUpdated);
        // click save
        driver.findElement(By.id("ItemEditSubmit")).click();

        // verificacion
        boolean isDisplayedProjectUpdate= driver.findElement(By.xpath("//table[@class='ProjItemTable']//td[text()='"+nameUpdated+"']")).isDisplayed();
        Assertions.assertTrue(isDisplayedProjectUpdate,"ERROR el project no fue actualizado");


        // DELETE

        //select el projecto creado
        driver.findElement(By.xpath("//li[last()]//td[text()='"+nameUpdated+"'] ")).click();
        // click en el menu del project
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();

        // click delete button
        driver.findElement(By.id("ProjShareMenuDel")).click();
        // alert --> click OK button
        driver.switchTo().alert().accept();
        // verificacion
         actualResult=driver.findElement(By.id("CurrentProjectTitle")).getText();
         expectedResult=nameUpdated;
        Assertions.assertNotEquals(expectedResult,actualResult,"ERROR! el projecto no fue borrado");

    }
}
