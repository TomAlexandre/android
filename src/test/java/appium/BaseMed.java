package appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: BaseMed
 * @PackageName: com.selenium
 * @Description: BaseDish演练
 * @Date: 2020-11-16 10:23 AM
 */
public class BaseMed {

    public static AppiumDriver apDriver;

    public WebDriverWait wait;

    public BaseMed(AppiumDriver apDriver) {
        this.apDriver = apDriver;
    }

    public BaseMed() {
    }

    void click (By by) {
        apDriver.findElement(by).click();
    }

    void sendKeys (By by,String content) {
        apDriver.findElement(by).sendKeys(content);;
    }
}
