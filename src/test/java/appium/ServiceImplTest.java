package appium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Version: 1.0
 * @Author: chriswang66
 * @ClassName: ServiceImplTest
 * @PackageName: com.selenium
 * @Description: ContactMenuTest演练
 * @Date: 2020-11-16 11:14 AM
 */
//添加断言
public class ServiceImplTest {

    public static MainDispch mainMenu;

    @BeforeAll
    static void loadData() throws IOException {
        mainMenu = new MainDispch();
    }

    // getCurrentDepartName
    @Test
    public void addMember() throws InterruptedException {
        mainMenu.jumpServieIpl().addMember("王磊10", "13212780858", "445282673@qq.com", "11abc");
//        assertTrue(mainMenu.jumpServieIpl().getCurrentDepartName().contains("alibaba111"));
    }

    @Test
    public void sendMsg() throws InterruptedException {
        mainMenu.jumpServieIpl().search("alibaba").sendMessage("你好");
//        assertTrue(mainMenu.jumpServieIpl().getCurrentDepartName().contains("445282672"));
    }

    @Test
    public void searchMember() throws InterruptedException {
        mainMenu.jumpServieIpl().search("alibaba").backToHomePage();
//        assertTrue(mainMenu.jumpServieIpl().getCurrentDepartName().contains("445282672"));
    }

    @Test
    public void modifyMember() throws InterruptedException {
        mainMenu.jumpServieIpl().search("445282672").updateMember("alibaba111", "11abc1");
        assertTrue(mainMenu.jumpServieIpl().getCurrentDepartName().contains("alibaba111"));
    }

    @Test
    public void deleteMember() throws InterruptedException {
        mainMenu.jumpServieIpl().search("445282672").deleteMember();
        assertTrue(mainMenu.jumpServieIpl().getCurrentDepartName().contains("445282672"));
    }

}
