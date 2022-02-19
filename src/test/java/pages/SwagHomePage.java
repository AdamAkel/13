package pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagHomePage {
    public SwagHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "app_logo")
    private WebElement logoElement;

    public boolean isDisplayedM() {
        return logoElement.isDisplayed();
    }


}
