package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import untils.Utils;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static untils.Utils.waitSeconds;

@Slf4j
public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement buttonSort;

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
    @FindBy(xpath = "//div[@class='product-description']")
    private List<WebElement> allProductsName;
    private List<AllProductsComponent> saveList;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage waitSeconds(long seconds) {
        waitSeconds(seconds);
        return this;
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

    public HomePage selectSortedPriceLowHigh() {
        sortPriceLowToHigh.click();
        return this;
    }

    public List<AllProductsComponent> getAllElementsFromPage() throws InterruptedException {
        List<AllProductsComponent> products = new ArrayList<>();
        List<WebElement> containers = allProductsName;
        waitSeconds(2);
        for (WebElement container : containers) {
            AllProductsComponent allProductsComponent = new AllProductsComponent(container);
            products.add(allProductsComponent);
        }
        return products;
    }

    public void clickButtonNext() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(buttonNext);
        actions.click();
        actions.perform();
    }

    public List<AllProductsComponent> mergeList() throws InterruptedException {
        List<AllProductsComponent> one = getAllElementsFromPage();
        clickButtonNext();
        List<AllProductsComponent> two = getAllElementsFromPage();
        one.addAll(two);
        saveList = one;
        return one;
    }

    public List<AllProductsComponent> sortedAZ() throws InterruptedException {
        List<AllProductsComponent> sorted = new ArrayList<>(saveList);
        Collections.sort(sorted, AllProductsComponent.NAME_COMPARATOR);
        return sorted;
    }

    public List<AllProductsComponent> sortedZA() throws InterruptedException {
        List<AllProductsComponent> sorted = new ArrayList<>(sortedAZ());
        Collections.reverse(sorted);
        return sorted;
    }

    public List<AllProductsComponent> sortedPriceLowHigh() throws InterruptedException {
        List<AllProductsComponent> sorted = new ArrayList<>(saveList);
        sorted.sort(Comparator.comparingDouble(AllProductsComponent::getPriceValue));
        return sorted;
    }

    public List<AllProductsComponent> sortedPriceHighLow() throws InterruptedException {
        List<AllProductsComponent> sorted = new ArrayList<>(saveList);
        sorted.sort(Comparator.comparingDouble(AllProductsComponent::getPriceValue).reversed());
        return sorted;
    }

    public HomePage selectSortedPriceHighLow() {
        sortPriceHighToLow.click();
        return this;
    }

}
