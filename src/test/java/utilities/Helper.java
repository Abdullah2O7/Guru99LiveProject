package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    WebDriver driver;
    TakesScreenshot takesScreenshot;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.takesScreenshot = (TakesScreenshot) this.driver;
    }

    // capture a screenshot of the current page
    public void captureScreenshotOfPage( String fileName)
    {
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        {
            try {
                FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"/ScreenShots/PageScreenshots/"+fileName+".png"));
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
    public static void captureScreenshot(WebDriver driver,String ScreenshotName)
    {
        Path destination = Paths.get("./Screenshots/FailedTestCasesScreenshots" , ScreenshotName + ".png");

        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream Output = new FileOutputStream(destination.toString());
            Output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            Output.close();

        } catch (IOException e) {
            System.out.println("Exception while taking Screenshot"+e.getMessage());
        }
    }

}
