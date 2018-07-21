package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by user on 7/20/18.
 */
public class HomePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "android.widgetFrameLayout")
    private WebElement timeZonePopup;

    @FindBy(id = "button1")
    private WebElement timeZoneYesButton;

    @FindBy(id = "button2")
    private WebElement timeZoneNoButton;

    @FindBy(className = "android.widget.ImageButton")
    private WebElement burgerMenuButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Expand/collapse']")
    private List<WebElement> projectsDownButton;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> burgerMenuItemsTexts;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkTimeZonePopup(){
        return timeZonePopup.isDisplayed();
    }

    public void clickTimeZoneNoButton(){
       // wait.until(ExpectedConditions.elementToBeClickable(timeZoneNoButton)).click();
        timeZoneNoButton.click();
    }
    public void clickTimeZoneYesButton(){
       // wait.until(ExpectedConditions.elementToBeClickable(timeZoneYesButton)).click();
        timeZoneYesButton.click();
    }


    public void clickBurgerMenu(){
       // wait.until(ExpectedConditions.elementToBeClickable(burgerMenuButton)).click();
        burgerMenuButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickProjectsDownButton(){
       // wait.until(ExpectedConditions.elementToBeClickable(projectsDownButton)).click();
        projectsDownButton.get(0).click();
    }

    public boolean checkProject(String projectName){
        for(WebElement i:burgerMenuItemsTexts){
            if(i.getText().equals(projectName)){
                return true;
            }
        }
        return false;
    }
    public void clickProject(String projectName){
        for(WebElement i:burgerMenuItemsTexts){
            if(i.getText().equals(projectName)){
                i.click();
                break;
            }
        }
    }
    public void clickSettings(){
        for(WebElement i:burgerMenuItemsTexts){
            if(i.getText().equals("Settings")){
                i.click();
                break;
            }
        }
    }
}
