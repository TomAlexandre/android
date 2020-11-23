package junit5Test;

import com.sun.org.glassfish.gmbal.ParameterNames;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import javax.naming.Name;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: junit5Test.CurriculumTest
 * @PackageName: PACKAGE_NAME
 * @Description: CurriculumTest演练
 * @Date: 2020-11-20 10:14 AM
 */
public class CurriculumTest {
    public static AppiumDriver apDriver;

    public static AndroidDriver adDriver;

    private WebDriverWait wait;
    @BeforeAll
    static void setUp () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();//
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "xxx");
        caps.setCapability("uid", "127.0.0.1:7555");
//        caps.setCapability("avd", "127.0.0.1:7554");
        /*caps.setCapability("appPackage", "com.xueqiu.android");//
        caps.setCapability("noReset", "true");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");*/
//        caps.setCapability("appActivity", ".launch.WwMainActivity");
//        apDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        apDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);//?
        apDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        apDriver.findElement(By.id("i72")).click();
    }

    @Test
    void msgTest () throws InterruptedException, IOException {
        adDriver.makeGsmCall("5551234567", GsmCallActions.CALL);
        Thread.sleep(5000);
        adDriver.sendSMS("555-123-4567", "Appium send message");
        Thread.sleep(5000);
        adDriver.toggleAirplaneMode();
        Thread.sleep(5000);
        adDriver.toggleWifi();
        Thread.sleep(5000);
        adDriver.toggleData();

        adDriver.rotate(ScreenOrientation.LANDSCAPE);
        adDriver.rotate(ScreenOrientation.PORTRAIT);
        adDriver.lockDevice();

        Thread.sleep(3000);
        File screenShort = adDriver.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/android.png");
        FileUtils.copyFile(screenShort, file);

        adDriver.startRecordingScreen();
        adDriver.stopRecordingScreen();
        adDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        adDriver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));

        // emulator -list-avds
    }
    // xueqiudemo
    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    void paramTest(String name,String code,double i) {
        apDriver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);
        /*apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"))
                .click();*/
        apDriver.findElement(By.xpath("//*[@text='"+code+"']"))
                .click();
        System.out.println("current_price:::" + apDriver.findElement(By.id("current_price")).getText());
//        assertTrue(Double.parseDouble(apDriver.findElement(By.id("current_price")).getText()))
        apDriver.findElement(By.id("action_close"))
                .click();
        assertThat(Double.parseDouble(apDriver.findElement(By.id("current_price")).getText()),greaterThan(i));
    }

    private static Stream<Arguments> byNameGetPrice () {
        return Stream.of(
                Arguments.of("alibaba","BABA",200d),
                Arguments.of("baidu","BIDU",300d),
                Arguments.of("wangyi","NTES",900d),
                Arguments.of("google","GOOGLE",900d)
        );
    }

    // xueqiudemo
    // //*[@class='android.widget.Toast']   adb shell dumpsys window | grep mCurrent
    // //*[@text='Make a Popup!']   //*[@text='Search']
    @Test
    void toastTest() {
        apDriver.findElement(By.xpath("//*[@text='Make a Popup!']")).click();
        System.out.println(apDriver.getPageSource());
        apDriver.findElement(By.xpath("//*[@text='Search']")).click();
        System.out.println(apDriver.findElement(By.xpath("//*[@class='android.widget.Toast']")).getText());
        System.out.println(apDriver.getPageSource());

    }


    // xueqiudemo
    @Test
    void waitTest() {
        apDriver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        WebElement ali = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")));
        System.out.println(ali.getAttribute("enabled"));
        ali.click();

    }

    @Test
    void slipTst () throws InterruptedException {
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) apDriver;
//        driver.findElementByAndroidUIAutomator(new UiScrollable(new UiSelector().scrollable(true)));
        Thread.sleep(10000);
        int width = apDriver.manage().window().getSize().getWidth();
        int height = apDriver.manage().window().getSize().getHeight();

        TouchActions touchActions = new TouchActions(apDriver);
        touchActions.longPress((WebElement) PointOption.point((int)(width*0.5),(int)(height*0.8)))
                .moveToElement((WebElement) PointOption.point((int)(width*0.5),(int)(height*0.2)))
                .release().perform();
        /*WebElement webElement = apDriver.findElement(By.id("com.xueqiu.android:id/home_search"));
        if (webElement.getAttribute("enabled").equals("true")) {
            System.out.println("location:::" + webElement.getLocation());
            webElement.click();
            WebElement webElement1 = apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            if (webElement1.getAttribute("displayed").equals("true")) {
                System.out.println("搜索成功");
                webElement1.sendKeys("alibaba");
            } else {
                System.out.println("搜索失败");
            }
        }*/
    }

    @Test
    void determineTst () {
        WebElement webElement = apDriver.findElement(By.id("com.xueqiu.android:id/home_search"));
        if (webElement.getAttribute("enabled").equals("true")) {
            System.out.println("location:::" + webElement.getLocation());
            webElement.click();
            WebElement webElement1 = apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            if (webElement1.getAttribute("displayed").equals("true")) {
                System.out.println("搜索成功");
                webElement1.sendKeys("alibaba");
            } else {
                System.out.println("搜索失败");
            }
        }
    }

    // xueqiudemo
    @Test
    void searchTest() {
        apDriver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"))
                .click();
        System.out.println("current_price:::" + apDriver.findElement(By.id("current_price")).getText());
//        assertTrue(Double.parseDouble(apDriver.findElement(By.id("current_price")).getText()))
        assertThat(Double.parseDouble(apDriver.findElement(By.id("current_price")).getText()),greaterThan(259.00));
    }
}
