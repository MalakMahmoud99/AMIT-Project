package StepDefinitions;

import Pages.P03_Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D03_AddItems {
    P03_Homepage home=new P03_Homepage(Hooks.driver);
    SoftAssert softassert=new SoftAssert();

    @When("Click on Laptops under categories on the homepage")
    public void clickonlaptops() throws InterruptedException {
        home.clickonlaptops();
    }
    @And("Choose Product 1")
    public void choosefirstproduct() throws InterruptedException {
        home.clickonproduct1();
    }
    @And("Click on the Add to Cart button")
    public void clickonaddtocart(){
        home.clickonaddtocart();
    }
    @Then("Product 1 is added to the cart with confirmation")
    public void assertmsg() throws InterruptedException {
        Assert.assertEquals(home.getalerttext(),"Product added.","Not the same");
    }

    @When("back to laptops page")
    public void back(){
        home.backtopage();
    }
    @And("Choose Product2")
    public void chooseproduct2(){
        home.clickonproduct2();
    }
    @Then("Product 2 is added to the cart with confirmation")
    public void assertmsg2() throws InterruptedException {
        Assert.assertEquals(home.getalerttext(),"Product added.","Not the same");
    }
    @When("click on the cart")
    public void clickoncart(){
        home.clickoncart();
    }
    @Then("Both products are visible in the cart, with their respective titles and prices")
    public void assert2products() throws InterruptedException {
        Assert.assertTrue(home.checkproductisadded(),"The 2 items weren't added");
    }
    @Then("The total amount is calculated correctly based on the prices of both products")
    public void assertcalc(){
        Assert.assertTrue(home.makecalcaulations(),"wrong calculations");
    }
    @When("Click on the Place order button")
    public void clickplace(){
        home.clickonplaceorder();
    }
    @And("Verify that the total amount is calculated correctly on the placeholder page")
    public void asserttotal() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(home.asserttotal(),"Not the same");
    }
    @And("Fill in Name")
    public void fillname() throws InterruptedException {
        home.fillname("Malak");
    }
    @And("Country")
    public void fillcountry(){
        home.fillcountry("Egypt");
    }
    @And("City")
    public void fillcity(){
        home.fillcity("Cairo");
    }
    @And("Credit Card Number")
    public void fillcardnum(){
        home.fillcard("1111111111");
    }
    @And("Month and year")
    public void fillmonthandyear(){
        home.fillmonthandyear("May","2026");
    }
    @And("Click on the Purchase button")
    public void clickpurchase(){
        home.clickonpurchase();
    }
    @Then("A success message should be displayed: \"Thank you for your purchase!\"")
    public void assertpurchase(){
        Assert.assertEquals(home.getthetext(),"Thank you for your purchase!");
    }

    @And("invalid Month and year")
    public void enterinvalidmonthandyear(){
        home.fillmonthandyear("5","2020");
    }
    @Then("an error message about credit appears")
    public void asserterror(){
        Assert.assertEquals(home.getthetext(),"Invalid Credit Card","Accepts the credit");
    }
}
