package selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestBasicForm {

    WebDriver webDriver;
    String expected;
    String actual;
    Browser browser;
    BasicFormPOM basicForm;

    @Given("I am on the page")
    public void i_am_on_the_page() {

        browser = Browser.CHROME;

        if(browser.equals(Browser.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\charl\\selenium\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html\n");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        basicForm = new BasicFormPOM(webDriver);
    }

    @And("I enter a message")
    public void i_enter_message() {
        basicForm.setMessageInput("this is my message");
    }

    @When("I click the button")
    public void i_click_the_button() {
        assumeTrue(browser.equals(Browser.CHROME));
        basicForm.clickMessageButton();
    }

    @Then("I should have the message return to me")
    public void i_should_have_the_message_return_to_me() {
        actual = basicForm.getReturnedMessage();
        expected = "this is my message";
        assertThat(actual, equalTo(expected));
    }



}
