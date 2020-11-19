package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicFormPOM {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"user-message\"]")
    WebElement messageInput;

    @FindBy(xpath = "//*[@id=\"get-input\"]/button")
    WebElement messageButton;

    @FindBy(xpath = "//*[@id=\"display\"]")
    WebElement returnedMessage;

    public BasicFormPOM(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void setMessageInput(String message){
        messageInput.sendKeys(message);
    }

    public void clickMessageButton(){
        messageButton.click();
    }

    public String getReturnedMessage(){
        return returnedMessage.getText();
    }


}
