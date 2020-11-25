package appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: BaseMed
 * @PackageName: com.selenium
 * @Description: BaseDish演练
 * @Date: 2020-11-16 10:23 AM
 */
public class BaseMed {

    public static final Logger log = LoggerFactory.getLogger(BaseMed.class.getName());

    public static AppiumDriver apDriver;

    public WebDriverWait wait;

    public static final String ADDRESSBOOK = "//*[@text='通讯录']";

    public static final String ADDMEMBER = "//*[@text='添加成员']";

    /*public static final String ADDRESSBOOK = "//*[@text='通讯录']";

    public static final String ADDMEMBER = "//*[@text='添加成员']";*/

    public BaseMed(AppiumDriver apDriver) {
        this.apDriver = apDriver;
    }

    public BaseMed() {
    }

    public BaseMed click (By by) {
        // todo: 异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            apDriver.findElement(by).click();
            log.info("click by");
        } catch (ElementClickInterceptedException e) {
            log.info("by is not clickable");
            e.printStackTrace();
        }
        return this;
    }

    public BaseMed sendKeys (By by,String content) {
        apDriver.findElement(by).sendKeys(content);
        return this;
    }

    public BaseMed threadSleep (long millis) throws InterruptedException {
        Thread.sleep(millis);
        return this;
    }
}
