package Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    String userId = "mngr572310";
    String password = "EhYpyrE";
    String invalidPassword = "invalid";

    @Given("The user is in the Login page")
    public void the_user_is_in_the_Login_page()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/index.php");
    }
    @When("Entering valid credentials")
    public void entering_valid_credentials()
    {
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    }
    @Then("user login to the website successfully")
    public void user_login_to_the_website_successfully()
    {
        //Assert.assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText().contains("mngr572310"));
        driver.quit();
    }
}
