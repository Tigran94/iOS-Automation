package steps;

import io.appium.java_client.AppiumDriver;
import page.LoginPage;


/**
 * Created by user on 7/21/18.
 */
public class LoginStep {
    LoginPage loginPage;
    private AppiumDriver driver;
    protected static final String EMAIL = "testappricodetodoist2@gmail.com";
    protected static final String USERNAME = "testAppricode";
    protected static final String PASSWORD = "test123!@#";

    public LoginStep(AppiumDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);

    }
    public void login() {
        loginPage.setEmail(EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
    }
}
