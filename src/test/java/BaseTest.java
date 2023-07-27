import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.MainPage;

import java.time.Duration;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().maximize();
        BasePage.setWebDriver(driver);
        MainPage mainPage = new MainPage();
        mainPage.waitForPageLoading();
        mainPage.switchToFrame();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BasePage.getWebDriver().quit();
    }
}
