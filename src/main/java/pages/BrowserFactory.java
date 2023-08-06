package pages;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getBrowserInstance(BrowserType browser, ChromeOptions options) {
        switch (browser) {
            case CHROME:
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--enable-features=AutofillAddressSavePrompt@2");
                WebDriverManager.chromedriver().setup();
                ChromeDriverService service = ChromeDriverService.createDefaultService();
                return new ChromeDriver(service, options);
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }
}
