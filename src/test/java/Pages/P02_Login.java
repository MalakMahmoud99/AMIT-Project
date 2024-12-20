package Pages;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login {
    private static WebDriver driver;
    GeneralMethods methods=new GeneralMethods();

    public P02_Login (WebDriver driver){
        this.driver=driver;
    }

    By logbtn= By.id("login2");
    By usernamefield=By.id("loginusername");
    By password=By.id("loginpassword");
    By loginbtn=By.xpath("//button[text()='Log in']");
    By welcome=By.id("nameofuser");

    public void openlog(){
        driver.findElement(logbtn).click();
    }
    public void enterusername(String name){
        driver.findElement(usernamefield).sendKeys(name);
    }
    public void enterpassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickonlogin(){
        driver.findElement(loginbtn).click();
    }

    public String gettext(){
        return driver.findElement(welcome).getText();
    }
    public String geterrortext() throws InterruptedException {
        return methods.getalerttext(driver);
    }
}
