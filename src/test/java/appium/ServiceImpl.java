package appium;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: ServiceImpl
 * @PackageName: com.selenium
 * @Description: ContactMenu演练
 * @Date: 2020-11-16 10:35 AM
 */
public class ServiceImpl extends BaseMed {

    public ServiceImpl(AppiumDriver apDriver) {
        super(apDriver);
    }

    // 添加成员
    public ServiceImpl addMeb(String username,String mobile,String email,String address) throws InterruptedException {
        wait = new WebDriverWait(apDriver, 30, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/title")));//?
        // 通讯录
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        // 添加成员
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[6]/android.widget.RelativeLayout")).click();
        // 手动添加
        apDriver.findElement(By.id("cox")).click();
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys(username);
        apDriver.findElement(By.id("fow")).sendKeys(mobile);
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys(email);
        apDriver.findElement(By.id("iy")).click();
        apDriver.findElement(By.id("iz")).sendKeys(address);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
        return this;
    }

    // 删除成员
    public void deleteMeb() {
        apDriver.findElement(By.id("i6d")).click();
        apDriver.findElement(By.id("b_x")).click();
        apDriver.findElement(By.id("elh")).click();
        apDriver.findElement(By.id("blx")).click();
        apDriver.findElement(By.id("i63")).click();
    }

    // 更新成员
    public ServiceImpl updateMeb(String username,String address) throws InterruptedException {
        apDriver.findElement(By.id("i6d")).click();
        apDriver.findElement(By.id("b_x")).click();
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys(username);
        apDriver.findElement(By.id("iy")).click();
        apDriver.findElement(By.id("iz")).sendKeys(address);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i6k")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
        Thread.sleep(1000);
        apDriver.findElement(By.id("i63")).click();
        return this;
    }

    // 查询成员
    public ServiceImpl back() {
        apDriver.findElement(By.id("i63")).click();
        return this;
    }

    // 发送信息
    public ServiceImpl sendMsg(String message) {
        // 开始聊天
        apDriver.findElement(By.id("ajv")).click();
        apDriver.findElement(By.id("eo7")).sendKeys(message);
        apDriver.findElement(By.id("eo3")).click();
        // 退出聊天
        apDriver.findElement(By.id("i63")).click();
        return this;
    }

    // 底层查询
    public ServiceImpl search(String member) {
        wait = new WebDriverWait(apDriver, 30, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/title")));//?
        // 通讯录
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        apDriver.findElement(By.id("i6n")).click();
        apDriver.findElement(By.id("gpg")).sendKeys(member);
        apDriver.findElement(By.id("e6d")).click();
        return this;
    }

}
