import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.PricesDropComponent;
import pages.PricesDropPage;

import java.util.List;

public class PriceDropCheckTest extends BaseTest {
    @Test
    public void priceDropCheck() {
        MainPage mainPage = new MainPage();
        PricesDropPage pricesDropPage = new PricesDropPage();
        mainPage.clickPricesDrop();
        SoftAssert softAssert = new SoftAssert();
        List<PricesDropComponent> products = pricesDropPage.getPricesDropProduct();
        for (PricesDropComponent product : products) {
            softAssert.assertNotNull(product.getOldPrice());
            softAssert.assertNotNull(product.getCurrentPrice());
            softAssert.assertEquals(product.getCurrentPrice(),
                    Math.round((product.getOldPrice()
                            - product.getOldPrice() * product.getDiscountPercentageDiscountProduct()) * 100.0) / 100.0);
        }
        softAssert.assertAll();
    }
}
