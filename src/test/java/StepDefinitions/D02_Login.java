package StepDefinitions;

import Pages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

@Slf4j
public class D02_Login {
    P02_Login login=new P02_Login(Hooks.driver);
    SoftAssert softassert=new SoftAssert();

    @When("user click on login")
    public void navtologinpage(){
        login.openlog();
    }
    @And("enter his name")
    public void enterusername(){
        login.enterusername("MalakMahmoud");
    }
    @And("enter his password")
    public void enterpassword(){
        login.enterpassword("PAssword");
    }
    @And("click on login")
    public void clicklogin(){
        login.clickonlogin();
    }
    @Then("Login done successfully")
    public void assertlogin() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(login.gettext(),"Welcome MalakMahmoud","Not the same");
    }
    @And("enter invalid name")
    public void enterinvalidname(){
        login.enterusername("Maloka");
    }
    @Then("an error msg appears")
    public void asserterror() throws InterruptedException {
        Assert.assertEquals(login.geterrortext(),"User does not exist.","Login Successfully");
    }
}
