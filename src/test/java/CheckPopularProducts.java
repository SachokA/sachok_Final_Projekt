import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.PopularProductComponent;

import java.util.List;

public class CheckPopularProducts extends BaseTest {
    @Test
    public void checkPopularProducts() {
        MainPage mainPage = new MainPage();
        SoftAssert softAssert = new SoftAssert();
        int expectedSize = 8;
        int actualSize = mainPage.getSizePopularProduct();
        softAssert.assertEquals(actualSize, expectedSize);
        List<PopularProductComponent> products = mainPage.getPopularProduct();
        for (PopularProductComponent product: products) {
            softAssert.assertNotNull(product.getName());
            softAssert.assertNotNull(product.getCurrentPrice());
            softAssert.assertTrue(product.getCurrentPrice()>0.00);
        }
        softAssert.assertAll();
    }

}

