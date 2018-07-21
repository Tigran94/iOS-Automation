package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 7/21/18.
 */
public class SettingsPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "title")
    private List<WebElement> itemsTitles;
    @FindBy(id = "button1")
    private WebElement logOutYesButton;

    public SettingsPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogOutButton() throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement i : itemsTitles) {
            if (i.getText().equals("Log out")) {
                i.click();
                Thread.sleep(3000);
                break;
            }
        }
    }
    public void scroll() throws IOException {
        try {
            Dimension dimensions = driver.manage().window().getSize();
            System.out.println("Size of screen= " + dimensions);
            int Startpoint = (int) (dimensions.getHeight() * 0.5);
            System.out.println("Size of scrollStart= " + Startpoint);
            int scrollEnd = (int) (dimensions.getHeight() * 0.3);
            System.out.println("Size of scrollEnd= " + scrollEnd);
            driver.swipe(0, Startpoint, 0, scrollEnd, 2000);
        }catch (Exception e){

        }

    }
    public void clickLogoutYesButton(){
        logOutYesButton.click();
    }

}
