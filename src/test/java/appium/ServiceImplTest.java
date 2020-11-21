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
public class ServiceImplTest {

    public static MainDispch mainMenu;

    @BeforeAll
    static void loadData() throws IOException {
        mainMenu = new MainDispch();
    }

    @Test
    public void addMember() throws InterruptedException {
        mainMenu.jumpServieIpl().addMeb("王磊9", "13212780858", "445282673@qq.com", "11abc");
    }

    @Test
    public void sendMsg() {
        mainMenu.jumpServieIpl().search("alibaba").sendMsg("你好");
    }

    @Test
    public void searchMember() {
        mainMenu.jumpServieIpl().search("alibaba").back();
    }

    @Test
    public void modifyMember() throws InterruptedException {
        mainMenu.jumpServieIpl().search("alibaba").updateMeb("alibaba11", "11abc1");
    }


    @Test
    public void deleteMember() {
        mainMenu.jumpServieIpl().search("alibaba").deleteMeb();
    }

}
