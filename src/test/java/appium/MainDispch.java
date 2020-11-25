package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        String platformName = System.getenv("driver");
        apDriver = DriverFactory.getInstance().createAppiumDriver(platformName);
        new WebDriverWait(apDriver,120)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));
    }

    public ServiceImpl jumpServieIpl () {
//        click(By.xpath("//*[@text='通讯录']"));
//        click(By.linkText("通讯录"));
        return new ServiceImpl(apDriver);
    }
}
