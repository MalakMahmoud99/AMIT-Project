package Pages;

import GeneralMethods.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P03_Homepage {
    private static WebDriver driver;
    GeneralMethods methods = new GeneralMethods();
    String product1name;
    String product2name;
    String product1price;
    String product2price;
    List<String> productPrices = new ArrayList<>();
    String total1;

    public P03_Homepage(WebDriver driver) {
        this.driver = driver;
    }

    By laptops = By.xpath("//a[text()='Laptops']");
    By product1 = By.xpath("//div//a[@class='hrefch']");
    By product2 = By.xpath("//div//a[text()='MacBook air']");
    By addtocart = By.xpath("//a[text()='Add to cart']");
    By cart = By.id("cartur");
    By table = By.xpath("//table[@class='table table-bordered table-hover table-striped']");
    By body = By.id("tbodyid");
    By rows = By.xpath("//tr[@class='success']");
    By price1=By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h5");
    By price2=By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h5");
    By totalprice=By.id("totalp");
    By totalplaceorder=By.id("totalm");
    By namefield=By.id("name");
    By countryfield=By.id("country");
    By cityfield=By.id("city");
    By cardfield=By.id("card");
    By monthfield=By.id("month");
    By yearfield=By.id("year");
    By purchasebutton=By.xpath("//button[text()='Purchase']");
    By successmsg=By.xpath("/html/body/div[10]/h2");
    By placeorderbtn=By.xpath("//button[text()='Place Order']");


    public void clickonlaptops() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(laptops).click();
    }
    public void clickonproduct1() throws InterruptedException {
        Thread.sleep(2000);
        product1name=driver.findElement(product1).getText();
        product1price=driver.findElement(price1).getText().replace("$", "").trim();
        driver.findElement(product1).click();
    }
    public void clickonproduct2(){
        product2name=driver.findElement(product2).getText();
        product2price=driver.findElement(price2).getText().replace("$", "").trim();
        driver.findElement(product2).click();
    }
    public void clickonaddtocart(){
        driver.findElement(addtocart).click();
    }
    public String getalerttext() throws InterruptedException {
       return methods.getalerttext(driver);
    }
    public void backtopage(){
        driver.navigate().back();
        driver.navigate().back();
    }

    public void clickoncart(){
        driver.findElement(cart).click();
    }

    public Boolean checkproductisadded() throws InterruptedException {
        Thread.sleep(2000);
        WebElement tablee = driver.findElement(table);
        WebElement bod = driver.findElement(body);
        List<WebElement> row = bod.findElements(rows);
        List<String> productNames = new ArrayList<>();
        for (WebElement r : row) {
            String productName = r.findElement(By.xpath(".//td[2]")).getText();
            String productPrice = r.findElement(By.xpath(".//td[3]")).getText();
            productNames.add(productName);
            productPrices.add(productPrice);
        }
        if (productNames.contains(product1name) && productNames.contains(product2name) &&
                productPrices.contains(product1price) && productPrices.contains(product2price)) {
            return true;
        }

        return false;
    }

    public boolean makecalcaulations() {
        String totalPricesText = driver.findElement(totalprice).getText();
        double expectedTotal = Double.parseDouble(totalPricesText);
        double calculatedTotal = 0.0;
        for (String price : productPrices) {
            calculatedTotal += Double.parseDouble(price); // Convert each price to a number and sum it
        }
        if (expectedTotal==calculatedTotal) {
            return true;
        }
        return false;
    }
    public void fillname(String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(namefield).sendKeys(username);
    }
    public void fillcountry(String country){
        driver.findElement(countryfield).sendKeys(country);
    }
    public void fillcity(String city){
        driver.findElement(cityfield).sendKeys(city);
    }
    public void fillcard(String cardnum){
        driver.findElement(cardfield).sendKeys(cardnum);
    }
    public void fillmonthandyear(String month,String year){
        driver.findElement(monthfield).sendKeys(month);
        driver.findElement(yearfield).sendKeys(year);
    }
    public String getthetext(){
        return driver.findElement(successmsg).getText();
    }
    public void clickonplaceorder(){
        total1=driver.findElement(totalprice).getText();
        driver.findElement(placeorderbtn).click();
    }
    public void clickonpurchase(){
        driver.findElement(purchasebutton).click();
    }
    public boolean asserttotal(){
        String total2=driver.findElement(totalplaceorder).getText().replace("Total:","").trim();
        if (total1.equals(total2)){
            return true;
        } return false;
    }


}