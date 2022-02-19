package step_definitions;

import Utils.ConfigReader;
import Utils.Driver;
import Utils.SSM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SwagHomePage;
import pages.SwagLoginPage;

public class SwagStepDefs {

    WebDriver driver;
    SwagLoginPage loginPage;
    SwagHomePage homePage;

    String standardUserName = ConfigReader.readProperty("SUN");
    String LOuser = ConfigReader.readProperty("LOUN");
    String password = ConfigReader.readProperty("password");

    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {
    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field() {

        loginPage = new SwagLoginPage();
        loginPage.fillLogin(standardUserName, password);
    }

    @When("I click the Login Button")
    public void i_click_the_login_button() throws InterruptedException {

        loginPage = new SwagLoginPage();
        loginPage.clickLogin();
        Thread.sleep(2000);
        driver = Driver.getDriver();

    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() {
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

    @Then("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {

        homePage = new SwagHomePage();
        Assert.assertTrue(homePage.isDisplayedM());

    }

    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field() {
        loginPage = new SwagLoginPage();
        loginPage.fillLogin(LOuser, password);
    }

    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String string) {


        loginPage = new SwagLoginPage();
        String actualMessage = loginPage.getErrorMessageM();
        System.out.println("Actual message is >> " + actualMessage);
        SSM.getScreenShot(driver,"ss");
        Assert.assertTrue("Message doesn't contain the given string", actualMessage.contains(string));

    }


}
