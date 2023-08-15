package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class PopularProductComponent extends BasePage {
    private final By nameLocator = By.xpath(".//h3");
    private final By oldPriceLocator = By.xpath(".//span[@class='regular-price']");
    private final By currentPriceLocator = By.xpath(".//span[@class='price']");
    private final By discountLocator = By.xpath("//section[@class='featured-products clearfix']//li[@class='product-flag discount']");
    private String name;
    private Double currentPrice;
    private String oldPrice;
    private Double discountPercentageDiscountProduct;

    public PopularProductComponent() {
    }

    public PopularProductComponent(WebElement container) {

        this.name = container.findElement(nameLocator).getText();
        try {
            this.oldPrice = container.findElement(oldPriceLocator).getText().substring(1);
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }
        this.currentPrice = Double.valueOf(container.findElement(currentPriceLocator).getText().substring(1));
        String discountText = container
                .findElement(discountLocator)
                .getText();
        this.discountPercentageDiscountProduct = Double.valueOf(discountText.replaceAll("[^0-9]", "")) / 100.0;
    }
}

