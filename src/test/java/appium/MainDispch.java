package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: MainDispch
 * @PackageName: com.selenium
 * @Description: MainMenu演练
 * @Date: 2020-11-16 10:21 AM
 */
public class MainDispch extends BaseMed {

    public MainDispch() throws MalformedURLException {
        this.startLogin();
    }

    void startLogin () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();//
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "xxx");
        caps.setCapability("uid", "127.0.0.1:7555");
        caps.setCapability("appPackage", "com.tencent.wework");
        caps.setCapability("noReset", "true");
        caps.setCapability("appActivity", ".launch.WwMainActivity");
        apDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);//?
        apDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public ServiceImpl jumpServieIpl () {
//        click(By.linkText("通讯录"), INIT_NUM0);
        return new ServiceImpl(apDriver);
    }
}
