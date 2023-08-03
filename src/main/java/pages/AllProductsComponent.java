package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
public class AllProductsComponent {
    public static final Comparator<AllProductsComponent> NAME_COMPARATOR = Comparator.comparing(AllProductsComponent::getName);
    private String name;
    private String currentPrice;
    private String oldPrice;


    public AllProductsComponent() {
    }

    public AllProductsComponent(WebElement container) {
        this.name = container.findElement(By.xpath(".//a[@content]")).getAttribute("textContent");
        try {
            this.oldPrice = container.findElement(By.xpath(".//*[@class='regular-price']")).getAttribute("textContent").substring(1);
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }
        this.currentPrice = container.findElement(By.xpath(".//*[@class='price']")).getAttribute("textContent").substring(1);
    }
    @Override
    public String toString() {
        return "AllProductsComponent{" +
                "name='" + name + '\'' +
                ", price=" + currentPrice +
                '}';
    }
}
