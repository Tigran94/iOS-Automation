import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BeforeTest {
    private String apkDir = System.getProperty("apkDir");
    private String deviceName = System.getProperty("deviceName");
    private String version = System.getProperty("version");
    private String automatioName = System.getProperty("automationName");
    private boolean fullResrt = Boolean.getBoolean(System.getProperty("fullReset"));


    private static AndroidDriver driver;

    @BeforeClass
    public void initiateDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName",deviceName);
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+"/apk/Todoist_v12.8_apkpure.com.apk");
//        desiredCapabilities.setCapability("fullReset",fullResrt);
        desiredCapabilities.setCapability("appWaitActivity", "*");

        try {

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
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
        //driver.closeApp();
//        driver.close();
    }
}
