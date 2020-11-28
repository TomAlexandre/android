package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase {
    public List<String> data;
    public List<HashMap<String, Object>> steps;
    private ChromeDriver chromeDriver;
    private WebElement webElement;

    void run() {
        steps.forEach(step ->
                {
                    if (step.keySet().contains("chrome")) {
                        chromeDriver = new ChromeDriver();
                    }
                    if (step.keySet().contains("implicitly_wait")) {
                        chromeDriver
                                .manage()
                                .timeouts()
                                .implicitlyWait
                                        ((int) step.getOrDefault("implicitly_wait",
                                                5),
                                                TimeUnit.SECONDS);
                    }
                    if (step.keySet().contains("get")) {
                        chromeDriver.get(step.get("get").toString());
                    }
                    if (step.keySet().contains("find")) {
                        ArrayList<By> byList = new ArrayList<>();
                        ((HashMap<String, String>) step.get("find")).entrySet().forEach(stringStringEntry ->
                                {
                                    if (stringStringEntry.getKey().contains("id")) {
                                        byList.add(By.id(stringStringEntry.getValue()));
                                    }
                                    if (stringStringEntry.getKey().contains("xPath")) {
                                        byList.add(By.id(stringStringEntry.getValue()));
                                    }
                                }
                        );
                        webElement = chromeDriver.findElement(byList.get(0));
                    }

                    if (step.keySet().contains("click")) {
                        webElement.click();
                    }

                    if (step.keySet().contains("send_keys")) {
                        webElement.sendKeys("demo");
                    }
                }
        );
    }
}
