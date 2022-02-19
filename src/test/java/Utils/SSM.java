package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SSM {
    public static void getScreenShot(WebDriver driver, String packageName){
        // getScreenShotAs method is taking a screenshot and returning the file of this screen.
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"\\src\\main\\screenshot\\"+packageName+"\\";
        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()+".png"));
            System.out.println("The screenshot stored in " + location);
        } catch (IOException e) {
            System.out.println("Screenshot is not stored.");
            e.printStackTrace();
        }
    }
}
