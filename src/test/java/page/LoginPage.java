package page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 7/20/18.
 */
public class LoginPage {
    private AppiumDriver driver;

    @FindBy(id = "")
    private WebElement emailField;

    @FindBy(id = "")
    private WebElement continueWithEmailButton;

    @FindBy(id = "")
    private WebElement passwordField;

    @FindBy(id = "")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
      //  PageFactory.initElements(driver,this);
    }

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void clickContinueWithEmailButton(){
        continueWithEmailButton.click();
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();

    }

}
