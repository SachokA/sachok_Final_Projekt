package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class PricesDropPage extends BasePage{

    @FindBy(xpath = "//div[@class='js-product product col-xs-12 col-sm-6 col-xl-4']")
    private List<WebElement> pricesDropContainerLocator;

    public PricesDropPage(){
        PageFactory.initElements(getWebDriver(),this);
    }

    public List<PricesDropComponent> getPricesDropProduct(){
        log.info("Get list prices product");
        List<PricesDropComponent> products = new ArrayList<>();
        List<WebElement> containers = pricesDropContainerLocator;
        for (WebElement container : containers) {
            PricesDropComponent productComponent = new PricesDropComponent(container);
            products.add(productComponent);
        }
        return products;

}}
