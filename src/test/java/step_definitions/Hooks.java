package step_definitions;

import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    WebDriver driver;
    @Before
    public void setup() {
        System.out.println("setting up my driver");
        driver=Driver.getDriver();
        driver.get(ConfigReader.readProperty("Url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @After
    public void tearDown() {

        // Driver.tearDown();
    }
}
