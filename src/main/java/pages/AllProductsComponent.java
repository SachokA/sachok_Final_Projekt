package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class AllProductsComponent {
    public static final Comparator<AllProductsComponent> NAME_COMPARATOR = Comparator.comparing(AllProductsComponent::getName);
    private final By priceOldLocator = By.xpath(".//*[@class='regular-price']");
    private final By nameLocator = By.xpath(".//a[@content]");
    private final By currentPriceLocator = By.xpath(".//*[@class='price']");

    private String name;
    private Double currentPrice;
    private Double oldPrice;

    public AllProductsComponent() {
    }

    public AllProductsComponent(WebElement container) throws InterruptedException {
        this.name = container.findElement(nameLocator).getAttribute("textContent");
        try {
            this.oldPrice = Double.valueOf(container.findElement(priceOldLocator)
                    .getAttribute("textContent").substring(1).replaceAll("[^\\d.]", ""));
        } catch (NoSuchElementException e) {
            this.oldPrice = 0.0;
        }
        this.currentPrice = Double.valueOf(container.findElement(currentPriceLocator)
                .getAttribute("textContent").substring(1).replaceAll("[^\\d.]", ""));
    }

    public Double getPriceValue() {
        return (oldPrice != 0.0 ? oldPrice : currentPrice);
    }


    @Override
    public String toString() {
        return "AllProductsComponent{" +
                "name='" + name + '\'' +
                ", currentPrice='" +currentPrice + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                '}';
    }
}
