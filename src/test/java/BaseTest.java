import enums.BrowserType;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.BrowserFactory;
import pages.MainPage;

import java.time.Duration;

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
        log.info("Tests will run at {}x{} in {} browser.", width, height, browser);
        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

