package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testVoxySteps {

    WebDriver driver;
    String url ="https://web-stage.voxy.com/v2/#/login";
    String expected = "ATIVE SUA CONTA ";
    String name;
    String email = "glaucianybrandao@gmail.com";
    String message;
    String message_expected = "IH!";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("the user is at the login page")
    public void the_user_is_at_the_login_page() {
        driver.get(url);
    }

    @When("user clicks on I have a code")
    public void user_clicks_on_i_have_a_code() {
        driver.findElement(By.className("code-button")).click();
    }

    @Then("user should be redirected to the page Activate your account")
    public void user_should_be_redirected_to_the_page_activate_your_account() {
        driver.findElement(By.className("redeem-code-form__title")).isDisplayed();
        name = driver.findElement(By.className("redeem-code-form__title")).getText();
        Assert.assertEquals(expected, name);

    }
    @After
    public void closer(){
       // driver.close();
        driver.quit();
    }

    @When("user fill the email field with a valid unregistered email")
    public void user_fill_the_email_field_with_a_valid_unregistered_email() {
        driver.findElement(By.id("login_form_email_input_field")).sendKeys(email);
    }

    @When("press the continue button")
    public void press_the_continue_button() {
        driver.findElement(By.id("login_form_submit_button")).click();
    }

    @Then("a sorry message should be exhibit")
    public void a_sorry_message_should_be_exhibit() {
        message = driver.findElement(By.className("login-error-message__title")).getText();
        Assert.assertEquals(message, message_expected);
    }

}
