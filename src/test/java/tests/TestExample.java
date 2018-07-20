package tests;

import api.HttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class TestExample extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    TaskPage taskPage;

    @BeforeMethod
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        projectPage = new ProjectPage(driver);
        taskPage = new TaskPage(driver);
    }
    @Test
    public void test1(){
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
    public void test2(){
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

    @Test
    public void test3(){
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
        projectPage.clickTask("Task1");
        taskPage.clickCompleteButton();

        //TODO -> api call

        Assert.assertTrue(projectPage.checkTask("Task1"),"Task isn't present");

    }

}
