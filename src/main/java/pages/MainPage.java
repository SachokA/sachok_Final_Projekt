package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static untils.Utils.getList;
import static untils.Utils.hoverOver;

@Slf4j
public class MainPage extends BasePage {


    @FindBy(linkText = "CLOTHES")
    private WebElement clothesCategory;

    @FindBy(linkText = "ACCESSORIES")
    private WebElement accessoriesCategory;

    @FindBy(linkText = "ART")
    private WebElement artCategory;
    @FindBy(xpath = "//a[contains(text(), 'Art')]")
    private WebElement artSubMenu;

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
    private List<WebElement> clothesList;

    @FindBy(xpath = "//*[@id='category-7'or@id='category-8']/a")
    private List<WebElement> accessoriesList;

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement loadingMessage;
    @FindBy(xpath = "//iframe[@title='Frame of demo shop']")
    private WebElement iframeFrameOfDemoShop;

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//section[@class='featured-products clearfix']//div[@class='product-description']")
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

    public void clickButtonLanguageDropdown() {
        buttonLanguageDropdown.click();
    }

    public List<String> getListLanguages() {
        return getList(languagesList);
    }

    public List<String> getClothesSubMenu() {
        return getList(clothesList);
    }

    public List<String> getAccessoriesList() {
        return getList(accessoriesList);
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

    public PricesDropPage clickPricesDrop() {
        log.info("Click button prices drop");
        pricesDrop.click();
        return new PricesDropPage();
    }

    public HomePage clickAllProducts() {
        log.info("Click button All Products");
        allProducts.click();
        return new HomePage();
    }

    public ResultSearchPage setFieldSearch(String value) {
        log.info("Set field search and enter");
        inputSearch.sendKeys(value);
        inputSearch.sendKeys(Keys.ENTER);
        return new ResultSearchPage();
    }

    public MainPage hoverOverClothesCategory() {
        log.info("Hover over clothes category");
        hoverOver(clothesCategory);
        return this;
    }

    public MainPage hoverOverAccessoriesCategory() {
        log.info("Hover over accessories category");
        hoverOver(accessoriesCategory);
        return this;

    }

    public MainPage hoverOverArtCategory() {
        log.info("Hover over art category");
        hoverOver(artCategory);
        return this;
    }

    public String getArtValue() {
        log.info("Check that no any sub category appears");
        return artSubMenu.getAttribute("class");
    }
}


