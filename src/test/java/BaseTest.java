import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.BrowserFactory;
import pages.MainPage;

import java.time.Duration;

@Slf4j
public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp() {
        int width = Integer.parseInt(System.getProperty("browser.width"));
        int height = Integer.parseInt(System.getProperty("browser.height"));
        String browser = System.getProperty("browser.type");
        log.info("Tests will run at {}x{} in {} browser.", width, height, browser);
        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        BasePage.setDriverThreadLocal(driver);
        MainPage mainPage = new MainPage();
        mainPage.waitForPageLoading();
        mainPage.switchToFrame();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BasePage.getDriver().quit();
    }
}
