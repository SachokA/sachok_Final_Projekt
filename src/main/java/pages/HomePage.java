package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement buttonSort;

    @FindBy(className = "dropdown-menu")
    private WebElement listValueForSorted;

    @FindBy(xpath = "//a[contains(text(),'Name, A to Z')]")
    private WebElement sortNameAZ;

    @FindBy(xpath = "//a[contains(text(),'Name, Z to A')]")
    private WebElement sortNameZA;

    @FindBy(xpath = "//a[contains(text(),'Price, low to high')]")
    private WebElement sortPriceLowToHigh;

    @FindBy(xpath = "//a[contains(text(),'Price, high to low')]")
    private WebElement sortPriceHighToLow;

    @FindBy(xpath = "//a[@class='next js-search-link']")
    private WebElement buttonNext;

    @FindBy(xpath = "//ul[@class='page-list clearfix text-sm-center']")
    private WebElement previous;

    @FindBy(xpath = "//div[@class='product-description']")
    private List<WebElement> allProductsName;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage clickButtonSorted() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", buttonSort);
        return this;
    }

    public HomePage selectSortedNameAZ() {
        sortNameAZ.click();
        return this;
    }

    public HomePage selectSortedNameZA() {
        sortNameZA.click();
        return this;
    }

    public List<AllProductsComponent> getAllElementsFromPage()  {
        List<AllProductsComponent> products = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(allProductsName));
        List<WebElement> containers = allProductsName;
        for (WebElement container : containers) {
            AllProductsComponent allProductsComponent = new AllProductsComponent(container);
            products.add(allProductsComponent);
        }
        return products;
    }

    public void clickButtonNext(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(buttonNext).click().perform();
    }
    public List<AllProductsComponent> mergeList(){
        List<AllProductsComponent> one = getAllElementsFromPage();
        clickButtonNext();
        List<AllProductsComponent> two = getAllElementsFromPage();
        one.addAll(two);
        return one;
    }
}
