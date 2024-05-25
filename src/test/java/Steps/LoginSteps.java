package Steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class LoginSteps {
    WebDriver driver;
    //String userId = "mngr572310";
    //String password = "EhYpyrE";
    String invalidPassword = "invalid";

    @Given("The user is in the Login page")
    public void the_user_is_in_the_Login_page()
    {
        System.out.println("Step1 : user is in the login page");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/index.php");
    }
    @When("user enters valid (.*) and (.*)$")
    public void entering_valid_credentials(String name, String password)
    {
        System.out.println("Step2 : user enters valid credentials");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    }
    @Then("user login to the website successfully")
    public void user_login_to_the_website_successfully()
    {
        System.out.println("Step3 : user can login successfully");
        //Assert.assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText().contains("mngr572310"));
        driver.quit();
    }

    @When("user enters valid credentials using DataTable")
    public void user_enters_valid_credentials_using_data_table(DataTable dataTable) {
        System.out.println("Step2 : user enters valid credentials using DataTable");
        List<List<String>> data = dataTable.cells();
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get(1));

    }
}
