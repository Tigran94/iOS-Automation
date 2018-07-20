
import api.HttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.MainPage;

public class TestExample extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    void test1() throws InterruptedException {
        HttpClient.createProjct();
        mainPage.clickWithEmailButton();
        loginPage.setEmail(EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        try {
            if(homePage.checkTimeZonePopup()){
                homePage.clickTimeZoneNoButton();
            }
        }catch (Exception e){
        }
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        Assert.assertTrue(homePage.checkProject("Project1"),"Project isn't present");}
}
