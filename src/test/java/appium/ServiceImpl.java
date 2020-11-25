package appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    private By addressBook = By.xpath(ADDRESSBOOK);

    private By addMember = By.xpath(ADDMEMBER);

    private By manualInputAdd = By.id("cox");

    private By inputUsername = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText");

    private By inputMobile = By.id("fow");

    private By inputEmail = By.xpath("hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.EditText");

    private By manualInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout");

    private By inputAddress = By.id("iz");

    private By confirmButton = By.id("i6k");

    private By backButton = By.id("i63");

    private By triangleSymbol = By.id("i6d");

    private By editMember = By.id("b_x");

    private By deleteMember = By.id("elh");

    private By confirmDelete = By.id("blx");

    private By sendMessage = By.id("ajv");

    private By inputMessage = By.id("eo7");

    private By sendButton = By.id("eo3");

    private By searchButton = By.id("i6n");

    private By inputName = By.id("gpg");

    private By clickName = By.id("e6d");

    public ServiceImpl(AppiumDriver apDriver) {
        super(apDriver);
    }

    // 添加成员
    public ServiceImpl addMember(String username,String mobile,String email,String address) throws InterruptedException {
        wait = new WebDriverWait(apDriver, 30, 1);
        enterManualInput() // 进入手动添加成员页面
                .inputUserInformation(username,mobile,email,address) // 输入用用户名、手机号、电子邮件、地址信息
                .backToOriginalPage(); // 返回通讯录页面
        return this;
    }


    // 删除成员
    public void deleteMember() {
        getIntoEditPage()
                .completeDlete();
    }

    // 更新成员
    public ServiceImpl updateMember(String username,String address) throws InterruptedException {
        getIntoEditPage()
                .inputUserInformation(username,address)
                .backToOriginalPage();
        return this;
    }


    // 发送信息
    public ServiceImpl sendMessage(String message) throws InterruptedException {
        // 开始聊天
      click(sendMessage)
            .sendKeys(inputMessage,message)
            .click(sendButton)
            .click(backButton);
        return this;
    }

    // 查询成员名称
    public ServiceImpl search(String memberName) throws InterruptedException {
        wait = new WebDriverWait(apDriver, 30, 1);
        searchName(memberName);
        return this;
    }

    public String getCurrentDepartName () {
        StringBuffer buffer = new StringBuffer();
        apDriver.findElements(addressBook).forEach(content->{
            buffer.append(((WebElement)content).getText());
        });
        System.out.println("buffer.toString()" + buffer.toString());
        return buffer.toString();
    }

     // 进入手动添加成员页面
    ServiceImpl enterManualInput () {
        click(addressBook)
                .click(addMember)
                .click(manualInputAdd);
        return this;
    }

    // 输入用户具体信息
    ServiceImpl inputUserInformation (String username,String mobile,String email,String address) {
        sendKeys(inputUsername,username)
                .sendKeys(inputMobile,mobile)
                .sendKeys(inputEmail,email)
                .click(manualInput)
                .sendKeys(inputAddress,address);
        return this;
    }

    // 输入用户地址信息
    ServiceImpl inputUserInformation (String username,String address) throws InterruptedException {
        sendKeys(inputUsername,username)
                .click(manualInput)
                .threadSleep(1000)
                .sendKeys(inputAddress,address);
        return this;
    }

    // 返回通讯录页面
    ServiceImpl backToPage () throws InterruptedException {
        click(confirmButton)
                .click(confirmButton)
                .click(backButton);
        return this;
    }

    // 返回通讯录页面
    ServiceImpl backToOriginalPage () throws InterruptedException {
        backToPage ()
            .click(backButton);
        return this;
    }


    // 进入编辑页面
    public ServiceImpl getIntoEditPage () {
        click(triangleSymbol)
                .click(editMember);
        return this;
    }

    // 完成删除
    public ServiceImpl completeDlete () {
        click(deleteMember)
                .click(confirmDelete)
                .click(backButton);
        return this;
    }

    // 底层查询
    public ServiceImpl searchName(String memberName) throws InterruptedException {
        click(addressBook) // 跳转通讯录
                .click(searchButton)
                .sendKeys(inputName,memberName)
                .threadSleep(1000)
                .click(clickName)
                .threadSleep(1000); // 为了等待信息出现
        return this;
    }

    // 一次返回
    public ServiceImpl backToHomePage() throws InterruptedException {
        click(backButton)
            .click(backButton);
        return this;
    }

}
