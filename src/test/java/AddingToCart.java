import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.ResultSearchPage;

@Test
public class AddingToCart extends BaseTest {

    public void addingToCart() {
        MainPage mainPage = new MainPage();
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        SoftAssert softAssert = new SoftAssert();
        String actualMessage = mainPage.setFieldSearch("Bear")
                .clickBrownBearNotebook()
                .select("Doted")
                .setInputQuantityWanted()
                .getMessageSuccessfully();
        softAssert.assertEquals(actualMessage,"Product successfully added to your shopping cart");
        String actualTypePaper = resultSearchPage.getTypePaper();
        softAssert.assertEquals(actualTypePaper,"Paper Type: Doted");
        String actualQuantity = resultSearchPage.getProductQuantity();
        softAssert.assertEquals(actualQuantity,"Quantity: 5");
        double actualTotal = resultSearchPage.getTotalPrice();
        double expectedTotal = resultSearchPage.getProductPrice()*5;
        softAssert.assertEquals(actualTotal,expectedTotal);
        softAssert.assertAll();

    }
}
