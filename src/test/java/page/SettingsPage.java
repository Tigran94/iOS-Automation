package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by user on 7/21/18.
 */
public class SettingsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> itemsTitles;
    @FindBy(id = "button1")
    private WebElement logOutYesButton;

    public SettingsPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogOutButton() {
        for (WebElement i : itemsTitles) {
            if (i.getText().equals("Log out")) {
                i.click();
                break;
            }
        }
    }
    public void scrollTo(String itemName) {
        for (WebElement i : itemsTitles) {
            if (i.getText().equals("Log out")) {
                driver.scrollTo(itemName);
                break;
            }
        }
    }
    public void clickLogoutYesButton(){
        logOutYesButton.click();
    }

}
