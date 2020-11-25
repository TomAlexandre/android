package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
// 工厂模式
public class DriverFactory {
    private static DriverFactory instace;
    public static DriverFactory getInstance() {
        if (instace == null) {
            return new DriverFactory();
        }
        return instace;
    }

    public AppiumDriver createAppiumDriver (String platformName) throws MalformedURLException {
        String platformNm = platformName;
        AppiumDriver appiumDriver;
        appiumDriver = null;
        if (platformName.equals("android")) {
            DesiredCapabilities caps = new DesiredCapabilities();//
            caps.setCapability("platformName", "android");
            caps.setCapability("deviceName", "xxx");
            caps.setCapability("uid", "127.0.0.1:7555");
            caps.setCapability("appPackage", "com.tencent.wework");
            caps.setCapability("noReset", "true");
            caps.setCapability("appActivity", ".launch.WwMainActivity");
            caps.setCapability("dontStopAppOnReset", "true");
            appiumDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return appiumDriver;
        } else if (platformName.equals("ios")) {
        } else if (platformName.equals("firefox")) {
        }
        return appiumDriver;
    }

}
