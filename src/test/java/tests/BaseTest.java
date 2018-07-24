package tests;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeClass
    public void initiateDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceReadyTimeout",10);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM,"8.1");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        desiredCapabilities.setCapability("deviceName", "Localization");
        desiredCapabilities.setCapability("udid", "6F57680D-F5F0-49AF-811F-87B3143E6F9B");
        desiredCapabilities.setCapability("deviceName","iPhone 8");
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+ "/src/test/resource/iosFiles/Insta.ipa");
        desiredCapabilities.setCapability("appWaitActivity", "*");
        desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        desiredCapabilities.setCapability("noReset", "true");
        try {
            startServer();
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
        }
    }

    public void startServer(){
        Runtime runtime = Runtime.getRuntime();
        if(SystemUtils.IS_OS_WINDOWS){
            try {
                runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(SystemUtils.IS_OS_MAC){
            try{
                runtime.exec("appium -a 127.0.0.1 -p 4723");
            }catch (IOException e){
                e.fillInStackTrace();
            }
        }
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.fillInStackTrace();
        }
    }

    public void quitTask(){
        Runtime runtime = Runtime.getRuntime();
        if(SystemUtils.IS_OS_WINDOWS) {
            try {
                runtime.exec("taskkill /F /IM node.exe");
                runtime.exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                e.fillInStackTrace();
            }
        }
        if(SystemUtils.IS_OS_MAC){
            try{
                runtime.exec("killall appium");
                runtime.exec("exit");
            }catch (IOException e){
                e.fillInStackTrace();
            }
        }
    }

    @AfterClass
    public void closeAppium(){
        quitTask();
    }
}
