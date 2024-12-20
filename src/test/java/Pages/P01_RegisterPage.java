package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class P01_RegisterPage {
    private static WebDriver driver;

    public P01_RegisterPage (WebDriver driver){
        this.driver=driver;
    }


    By signupbtn= By.id("signin2");
    By usernamefield=By.id("sign-username");
    By passwordfield=By.id("sign-password");
    By signbtn=By.xpath("//button[text()='Sign up']");


    public void openregisterpage(){
        driver.findElement(signupbtn).click();
    }
    public void entername(String name){
        driver.findElement(usernamefield).sendKeys(name);
    }

    public void enterpassword(String password){
        driver.findElement(passwordfield).sendKeys(password);
    }
    public void clickonsign(){
        driver.findElement(signbtn).click();
    }
    public String gettext() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alerttext=alert.getText();
        alert.accept();
        return alerttext;
    }

}
