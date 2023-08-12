import com.google.common.collect.ImmutableList;
import enums.BrowserType;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.BrowserFactory;
import pages.MainPage;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BaseTest {

    public void takeScreenshotAndAttachToAllure() {
        byte[] screenshot = takeScreenshot();
        attachScreenshotToAllure(screenshot);
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenshot) {
        return screenshot;
    }

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp() {
        int width = Integer.parseInt(System.getProperty("browser.width"));
        int height = Integer.parseInt(System.getProperty("browser.height"));
        String browser = System.getProperty("browser.type");
        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));
        log.info("Tests will run at {}x{} in {} browser.", width, height, browser);
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        BasePage.setDriverThreadLocal(driver);
        MainPage mainPage = new MainPage();
        mainPage.waitForPageLoading();
        mainPage.switchToFrame();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshotAndAttachToAllure();
        }
        BasePage.getDriver().quit();
    }
}

