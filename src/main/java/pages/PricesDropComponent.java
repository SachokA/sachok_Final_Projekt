package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class PricesDropComponent extends BasePage {
    private final By nameLocator = By.xpath(".//div[@class='product-description']//h2//a");
    private final By oldPriceLocator = By.xpath(".//div[@class='product-price-and-shipping']//span[@class='regular-price']");
    private final By currentPriceLocator = By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']");
    private final By discountLocator = By.xpath(".//li[@class='product-flag discount']");
    private String name;
    private Double currentPrice;
    private double oldPrice;
    private Double discountPercentageDiscountProduct;

    public PricesDropComponent() {
    }

    public PricesDropComponent(WebElement container) {
        this.name = container.findElement(nameLocator).getText();
        try {
            this.oldPrice = Double.parseDouble(container.findElement(oldPriceLocator).getText().substring(1));
        } catch (NoSuchElementException e) {
            this.oldPrice = 0.0;
        }
        this.currentPrice = Double.valueOf(container.findElement(currentPriceLocator).getText().substring(1));
        this.discountPercentageDiscountProduct = 0.01 * (Double.valueOf(container.findElement(discountLocator).getText().substring(1, 3)));
    }
}
