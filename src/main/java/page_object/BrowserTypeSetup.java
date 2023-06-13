package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTypeSetup {
    private final static Browser CURRENT_BROWSER = Browser.CHROME;
    private static final ChromeOptions options = new ChromeOptions();

    public static WebDriver browserDriverSetUp(){
        WebDriver driver = null;
        options.addArguments("--remote-allow-origins=*");
        switch (CURRENT_BROWSER) {
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "C:/Study/QA_Automation_Java/yandexdriver.exe");
                driver = new ChromeDriver(options);
                break;
            case CHROME:
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}
