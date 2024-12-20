package GeneralMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralMethods {
    private static WebDriver driver;
    WebDriverWait wait;

    public void waittellbuttonappear(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectfromdropdownlist(WebDriver driver, By locator, String visibletext) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibletext);
    }

    public String getalerttext(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        alert.accept();
        return alerttext;
    }
}