package StepDefinitions;

import Pages.P01_RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    P01_RegisterPage register  = new P01_RegisterPage(Hooks.driver);;
    SoftAssert softassert = new SoftAssert();

    @When("Click on the Sign up button")
    public void navtosignup(){
        register.openregisterpage();
    }
    @And("Fill in the username")
    public void entername(){
        register.entername("Malak999");
    }
    @And("password in the signup form")
    public void enterpass(){
        register.enterpassword("PAssword");
    }
    @And("Click on Sign Up")
    public void clicksignup(){
        register.clickonsign();
    }
    @Then("A success message should be displayed: \"Sign up successful\"")
    public void assertmessage() throws InterruptedException {
        Assert.assertEquals(register.gettext(),"Sign up successful.","Not the same");
    }
    @Then("an error message appears")
    public void asserterror() throws InterruptedException {
        Assert.assertEquals(register.gettext(),"This user already exist.","Not the same");
    }

}
