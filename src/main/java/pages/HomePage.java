package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement buttonSort;

    @FindBy(xpath = "//a[contains(@class,'select-list js-search-link')]")
    private List<WebElement> listValueForSorted;
    @FindBy(xpath = "//a[contains(text(),'Name, A to Z')]")
    private WebElement sortNameAZ;

    @FindBy(xpath = "//a[contains(text(),'Name, Z to A')]")
    private WebElement sortNameZA;

    @FindBy(xpath = "//a[contains(text(),'Price, low to high')]")
    private WebElement sortPriceLowToHigh;

    @FindBy(xpath = "//a[contains(text(),'high to low')]")
    private WebElement sortPriceHighToLow;

    @FindBy(xpath = "//a[@class='next js-search-link']")
    private WebElement buttonNext;


    @FindBy(xpath = "//a[@content]")
    private List<WebElement> allProductsTitle;

    public HomePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public HomePage clickButtonSorted(){
      buttonSort.click();
      return this;}

    public HomePage selectSortedNameAZ(){
        sortNameZA.click();
        return this;
    }

//            case "Name, A to Z":
//                sortNameAZ.click();
//                break;
//            case "Name, Z to A":
//                sortNameZA.click();
//                break;
//            case "Price, low to high":
//                sortPriceLowToHigh.click();
//                break;
//            case "Price, high to low":
//                sortPriceHighToLow.click();
//                break;
//        }
//        return this;
        public List<String> getAllProducts() {

        List<String> list = new ArrayList<>();
//        int totalProducts = 19;
//        int productsPerPage = 12;
       int totalPages = 2;

        for (int page = 1; page <= totalPages; page++) {
            // Зібрати продукти на поточній сторінці
            List<WebElement> all = allProductsTitle;;

            for (WebElement element : all) {
                list.add(element.getText());

            }

            // Перейти на наступну сторінку, якщо це не остання сторінка
            if (page < totalPages) {
                Actions actions = new Actions(getWebDriver());
                actions.moveToElement(buttonNext).click().perform();
            }
        }return list;
    }
  public List<String> sortedNameAZ(){
      List<String> sortedNames = new ArrayList<>(getAllProducts());
      Collections.sort(sortedNames, String::compareToIgnoreCase);
      return sortedNames;
  }


}
