package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by user on 7/21/18.
 */
public class ProjectPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "fab")
    private WebElement fabButton;

    @FindBy(id = "message")
    private WebElement taskField;

    @FindBy(id = "button1")
    private WebElement sendButton;

    @FindBy(id="empty_content")
    private WebElement emptyContent;

    @FindBy(id = "action_mode_close_button")
    private WebElement backButton;

    @FindBy(id = "text")
    private List<WebElement> tasksTitles;

    @FindBy(id = "snackbar_action")
    private WebElement undoButton;

    @AndroidFindBy(id = "content_toolbar_container")
    private WebElement mainContainer;

    public ProjectPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickFabButton(){
        fabButton.click();
    }

    public void setTaskName(String taskName){
        taskField.sendKeys(taskName);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void clickBackButton(){
        backButton.click();
    }

    public void clickTask(String taskName){
        for(WebElement i : tasksTitles){
            if(i.getText().equals(taskName)){
                i.click();
                break;
            }
        }
    }
    public boolean checkTask(String taskName){
        for(WebElement i:tasksTitles){
            if(i.getText().equals(taskName)){
                return true;
            }
        }
        return false;
    }
    public void clickUndoButton(){
        undoButton.click();
    }
}
