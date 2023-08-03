package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class PricesDropComponent extends BasePage {
    private WebElement image;
    private String name;
    private Double currentPrice;
    private double oldPrice;
    private Double discountPercentageDiscountProduct;

    public PricesDropComponent() {
    }

    public PricesDropComponent(WebElement container) {
        this.image = container.findElement(By.xpath(".//div[@class='thumbnail-top']//a//img"));
        this.name = container.findElement(By.xpath(".//div[@class='product-description']//h2//a")).getText();
        try {
            this.oldPrice = Double.parseDouble(container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='regular-price']")).getText().substring(1));
        } catch (NoSuchElementException e) {
            this.oldPrice = 0.0; // Якщо елемент не знайдено, можна задати значення 0.0 або інше значення за замовчуванням.
        }
        this.currentPrice = Double.valueOf(container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']")).getText().substring(1));
        this.discountPercentageDiscountProduct = 0.01 * (Double.valueOf(container.findElement(By.xpath(".//li[@class='product-flag discount']")).getText().substring(1, 3)));
    }
}
