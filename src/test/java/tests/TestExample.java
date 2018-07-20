package tests;

import api.HttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.MainPage;
import page.ProjectPage;

public class TestExample extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;

    @BeforeMethod
    public void setUp(){
        mainPage = new MainPage(BaseTest.driver);
        loginPage = new LoginPage(BaseTest.driver);
        homePage = new HomePage(BaseTest.driver);
        projectPage = new ProjectPage(BaseTest.driver);
    }
    @Test
    void test1(){
        HttpClient.createProjct();
        mainPage.clickWithEmailButton();
        loginPage.setEmail(BaseTest.EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.setPassword(BaseTest.PASSWORD);
        loginPage.clickLoginButton();
        try {
            if(homePage.checkTimeZonePopup()){
                homePage.clickTimeZoneYesButton();
            }
        }catch (Exception e){
        }
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        Assert.assertTrue(homePage.checkProject("Project1"),"Project isn't present");
    }

    @Test
    void test2(){
        mainPage.clickWithEmailButton();
        loginPage.setEmail(BaseTest.EMAIL);
        loginPage.clickContinueWithEmailButton();
        loginPage.setPassword(BaseTest.PASSWORD);
        loginPage.clickLoginButton();
        try {
            if(homePage.checkTimeZonePopup()){
                homePage.clickTimeZoneYesButton();
            }
        }catch (Exception e){
        }
        homePage.clickBurgerMenu();
        homePage.clickProject("Project1");
        projectPage.clickFabButton();
        projectPage.setTaskName("Task1");
        projectPage.clickSendButton();
        projectPage.clickBackButton();

        //TODO -> api call
    }
}
