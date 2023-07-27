package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Slf4j
public class MainPage extends BasePage {


    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement textGetOurLatestNewsAndSpecialSales;

    @FindBy(xpath = "//p[contains(text(),'You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.')]")
    private WebElement textYouMayUnsubscribeAtAnyMoment;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement buttonSubscribe;

    @FindBy(xpath = "//div[@id='_desktop_language_selector']")
    private WebElement buttonLanguageDropdown;

    @FindBy(xpath = "//a[@data-iso-code]")
    private List<WebElement> languagesList;

    @FindBy(xpath = "//*[@id='category-4'or@id='category-5']/a")
    public List<WebElement> clothesList;

    @FindBy(xpath = "//*[@id='category-7'or@id='category-8']/a")
    public List<WebElement> accessoriesList;

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement loadingMessage;
    @FindBy(xpath = "//iframe[@title='Frame of demo shop']")
    public WebElement iframeFrameOfDemoShop;

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement buttonSignIn;

    @FindBy(linkText = "CLOTHES")
    public WebElement buttonClothes;

    @FindBy(linkText = "ACCESSORIES")
    public WebElement buttonAccessories;

    @FindBy(linkText = "ART")
    public WebElement buttonArt;

    @FindBy(xpath = "//section[@class='featured-products clearfix']//article")
    private List<WebElement> popularProductContainerLocator;

    @FindBy(xpath = "//a[@title='Our special products']")
    private WebElement pricesDrop;

    @FindBy(xpath = "//*[contains(text(),'All products')]")
    private WebElement allProducts;

    @FindBy(xpath = "//input[@name='s']")
    private WebElement inputSearch;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForPageLoading() {
        log.info("Waiting for page loading");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loadingMessage));
    }

    public void switchToFrame() {
        log.info("Switch to frame");
        getDriver().switchTo().frame(iframeFrameOfDemoShop);
    }

     public String getMessageOnPageGetOurLatestNewsAndSpecialSales() {
        log.info("Getting message near the email field");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", textGetOurLatestNewsAndSpecialSales);
        return textGetOurLatestNewsAndSpecialSales.getText();
    }

    public String getMessageOnPageOnMayUnsubscribeAtAnyMoment() {
        log.info("Getting message under email field");
        return textYouMayUnsubscribeAtAnyMoment.getText();
    }

    public String getMessageButtonSubscribe() {
        log.info("Getting CssValue with button subscribe");
        return buttonSubscribe.getCssValue("text-transform");
    }

    public List<String> getLanguages() {
        log.info("Getting list all languages");
        buttonLanguageDropdown.click();
        List<String> list = new ArrayList<>();
        List<WebElement> languages = languagesList;
        for (WebElement webElement : languages) {
            list.add(webElement.getText());
        }
        return list;
    }

    public List<String> getList(List<WebElement> webElement) {
        log.info("Getting list elements");
        List<String> list = new ArrayList<>();
        List<WebElement> clothes = webElement;
        for (WebElement element : clothes) {
            list.add(element.getText());
        }
        return list;
    }

    public int sizeLanguagesList() {
        log.info("Getting size list of languages");
        return getLanguages().size();
    }

    public boolean findingUkrainianLanguagesInList() {
        log.info("Checking the Ukrainian language is in the list");
        List<String> list = new ArrayList<>();
        List<WebElement> languages = languagesList;
        for (WebElement webElement : languages) {
            list.add(webElement.getText());
        }
        return list.contains("Українська");
    }

    public LoginPage clickButtonSignIn() {
        log.info("Clicking button Sign In");
        buttonSignIn.click();
        return new LoginPage();
    }

    public MainPage moveToElement(WebElement webElement) {
        log.info("Hover mouse over 'CLOTHES");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).perform();

        return this;
    }

    public String getArtValue() {
        log.info("Check that no any sub category appears");
        return buttonArt.getAttribute("class");
    }

    public List<PopularProductComponent> getPopularProduct() {
        log.info("Get list popular product");
        List<PopularProductComponent> products = new ArrayList<>();
        List<WebElement> containers = popularProductContainerLocator;
        for (WebElement container : containers) {
            PopularProductComponent productComponent = new PopularProductComponent(container);
            products.add(productComponent);
        }
        return products;
    }

    public int getSizePopularProduct() {
        log.info("Get size popular product");
        List<PopularProductComponent> products = new ArrayList<>();
        List<WebElement> containers = popularProductContainerLocator;
        for (WebElement container : containers) {
            PopularProductComponent productComponent = new PopularProductComponent(container);
            products.add(productComponent);
        }

        return products.size();
    }

    public PricesDropPage clickPricesDrop() {
        pricesDrop.click();
        return new PricesDropPage();
    }

    public HomePage clickAllProducts() {
        allProducts.click();
        return new HomePage();
    }

    public ResultSearchPage setFieldSearch(String value) {
        log.info("Set field search and enter");
        inputSearch.sendKeys(value);
        inputSearch.sendKeys(Keys.ENTER);
        return new ResultSearchPage();
    }
}
