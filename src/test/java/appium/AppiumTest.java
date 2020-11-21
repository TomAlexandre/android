package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
 * @ClassName: AppiumTest
 * @PackageName: com.appium
 * @Description: AppiumTest演练
 * @Date: 2020-11-17 7:47 PM
 */
public class AppiumTest {
    public static AppiumDriver apDriver;

    private WebDriverWait wait;

    @BeforeAll
    static void test1() throws MalformedURLException {
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

    // 添加成员
    @Test
    void addMeb() throws InterruptedException {
        wait = new WebDriverWait(apDriver, 30, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/title")));//?
        // 通讯录
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        // 添加成员
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[6]/android.widget.RelativeLayout")).click();
        // 手动添加
        apDriver.findElement(By.id("cox")).click();//
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys("王磊9");
        apDriver.findElement(By.id("fow")).sendKeys("13212780856");
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys("445282673@qq.com");
        apDriver.findElement(By.id("iy")).click();
        apDriver.findElement(By.id("iz")).sendKeys("11abc");
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
    }

    // 删除成员
    @Test
    void deleteMeb() {
        search("王磊9");
        apDriver.findElement(By.id("i6d")).click();
        apDriver.findElement(By.id("b_x")).click();
        apDriver.findElement(By.id("elh")).click();
        apDriver.findElement(By.id("blx")).click();
        apDriver.findElement(By.id("i63")).click();
    }

    // 更新成员
    @Test
    void updateMeb() throws InterruptedException {
        search("alibaba");
        apDriver.findElement(By.id("i6d")).click();
        apDriver.findElement(By.id("b_x")).click();
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys("alibaba11");
        apDriver.findElement(By.id("iy")).click();
        apDriver.findElement(By.id("iz")).sendKeys("11abc1");
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
    }

    // 查询成员
    @Test
    void searchMeb() {
        search("alibaba");
        apDriver.findElement(By.id("i63")).click();
    }

    // 发送信息
    @Test
    void sendMsg() {
        search("alibaba");
        // 开始聊天
        apDriver.findElement(By.id("ajv")).click();
        apDriver.findElement(By.id("eo7")).sendKeys("你好");
        apDriver.findElement(By.id("eo3")).click();
        // 退出聊天
        apDriver.findElement(By.id("i63")).click();
    }

    // 底层查询
    void search(String member) {
        wait = new WebDriverWait(apDriver, 30, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/title")));//?
        // 通讯录
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        apDriver.findElement(By.id("i6n")).click();
        apDriver.findElement(By.id("gpg")).sendKeys(member);
        apDriver.findElement(By.id("e6d")).click();
    }

    // xueqiudemo
    @Test
    void searchTest() {
        apDriver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        apDriver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
    }

    /*@BeforeAll
    static void setUp () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();//
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "xxx");
        caps.setCapability("uid", "127.0.0.1:7555");
//        caps.setCapability("appPackage", "com.xueqiu.android");//
        caps.setCapability("appPackage", "com.tencent.wework");

        caps.setCapability("noReset", "true");
//        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
        //.launch.WwMainActivity
        caps.setCapability("appActivity", ".launch.WwMainActivity");
//        apDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        apDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);//?
        apDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        apDriver.findElement(By.id("i72")).click();
    }*/
}
