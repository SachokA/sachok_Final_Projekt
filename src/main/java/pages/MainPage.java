package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MainPage extends BasePage {


    @FindBy(linkText = "CLOTHES")
    private WebElement clothesCategory;

    @FindBy(linkText = "ACCESSORIES")
    private WebElement accessoriesCategory;

    @FindBy(linkText = "ART")
    private WebElement artCategory;

    @FindBy(xpath = "//*[@id='category-4'or@id='category-5']/a")
    private List<WebElement> clothesSubMenu;
    @FindBy(xpath = "//*[@id='category-7'or@id='category-8']/a")
    private List<WebElement> accessoriesSubMenu;
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


    @FindBy(xpath = "//div[@class='popover sub-menu js-sub-menu collapse']")
    private WebElement subMenu;

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

    public List<String> getListClothes() {
        log.info("Getting list elements");
        List<String> list = new ArrayList<>();
        List<WebElement> clothes = clothesList;
        for (WebElement element : clothes) {
            list.add(element.getText());
        }
        return list;
    }

    public List<String> getListAccessories() {
        log.info("Getting list elements");
        List<String> list = new ArrayList<>();
        List<WebElement> accessories = accessoriesList;
        for (WebElement element : accessories) {
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
        Actions actions = new Actions(getDriver());
        actions.moveToElement(clothesCategory).perform();
        return this;

    }

    public MainPage hoverOverAccessoriesCategory() {
        log.info("Hover over accessories category");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(accessoriesCategory).perform();
        return this;

    }

    public MainPage hoverOverArtCategory() {
        log.info("Hover over art category");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(artCategory).perform();
        return this;
    }

    public List<String> getClothesSubMenuItems() {
        log.info("Get clothes subMenu clothes");
        List<String> clothes = new ArrayList<>();
        List<WebElement> subMenuClothes = clothesSubMenu;
        for (WebElement element : subMenuClothes) {
            clothes.add(element.getText());
        }
        return clothes;
    }

    public List<String> getAccessoriesSubMenuItems() {
        log.info("Get clothes subMenu accessories");
        List<String> accessories = new ArrayList<>();
        List<WebElement> subMenuAccessories = accessoriesSubMenu;
        for (WebElement element : subMenuAccessories) {
            accessories.add(element.getText());
        }
        return accessories;
    }

    public String getArtValue() {
        log.info("Check that no any sub category appears");
        return artSubMenu.getAttribute("class");
    }
}


