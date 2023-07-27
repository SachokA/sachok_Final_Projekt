package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class PopularProductComponent extends BasePage {
    private WebElement image;
    private String name;
    private Double currentPrice;
    private String oldPrice;
    private Double discountPercentageDiscountProduct;

    public PopularProductComponent() {
    }

    public PopularProductComponent(WebElement container) {
        this.image = container.findElement(By.xpath(".//img"));
        this.name = container.findElement(By.xpath(".//h3")).getText();
        try {
            this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText().substring(1);
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }
        this.currentPrice = Double.valueOf(container.findElement(By.xpath(".//span[@class='price']")).getText().substring(1));
        String discountText = container
                .findElement(By.xpath("//section[@class='featured-products clearfix']//li[@class='product-flag discount']"))
                .getText();
        this.discountPercentageDiscountProduct = Double.valueOf(discountText.replaceAll("[^0-9]", "")) / 100.0;
    }
}

