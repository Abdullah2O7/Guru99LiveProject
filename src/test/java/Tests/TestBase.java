package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.Report;

public class TestBase {
protected WebDriver driver;
Helper helper;

@BeforeClass
@Parameters({"browser"})
public void setUp(@Optional("firefox") String browserName)
{
    if(browserName.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("firefox")) {
        driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("edge")) {
        driver = new EdgeDriver();
    }

    driver.manage().window().maximize();
    driver.get("https://www.demo.guru99.com/V4/index.php");

    Report.setExtentReports();
}

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed\n Taking Screenshot.....");
            Helper.captureScreenshot(driver,result.getName());
        }else{
            helper = new Helper(driver);
            helper.captureScreenshotOfPage(result.getName());
        }
    }

@AfterTest
    public void quite() {
    Report.endReport();
    driver.quit();
    }
}
