import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sun.plugin2.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BeforeTest {
    private String apkDir = System.getProperty("apkDir");
    private String deviceName = System.getProperty("deviceName");
    private String systemOS = System.getProperty("os.name");





    private static AndroidDriver driver;

    @BeforeClass
    public void initiateDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceReadyTimeout",10);
        desiredCapabilities.setCapability("avd",deviceName.replace(" ","_"));
        desiredCapabilities.setCapability("deviceName",deviceName);
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+"/apk/Todoist_v12.8_apkpure.com.apk");
//        desiredCapabilities.setCapability("fullReset",fullResrt);
        desiredCapabilities.setCapability("appWaitActivity", "*");

        try {
            startServer();
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
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

//   // protected static AndroidDriver getDriver() {
//        return driver;
//    }

//    private DesiredCapabilities setupDesiredCapabilities(){
//
//
//
//        return desiredCapabilities;
//    }

    @AfterClass
    public void closeAppium(){
        quitTask();
        //driver.closeApp();
//        driver.close();
    }
}
