package pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLoginPage {

    public SwagLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement ErrorMessage;

    public void fillLogin(String userNameP, String passwordP) {
         userName.sendKeys(userNameP);
        password.sendKeys(passwordP);

    }

    public void clickLogin() {
        loginButton.click();

    }

    public String getErrorMessageM() {
        return ErrorMessage.getText();
    }

}
