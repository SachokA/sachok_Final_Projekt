import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ResultSearchPage;

@Test
public class AddingToCart extends BaseTest {

    public void addingToCart() {
        MainPage mainPage = new MainPage();
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        SoftAssertions softAssert = new SoftAssertions();
        String actualMessage = mainPage.setFieldSearch("Bear")
                .clickBrownBearNotebook()
                .select("Doted")
                .setInputQuantityWanted()
                .getMessageSuccessfully();
        softAssert.assertThat(actualMessage).as("not as expected")
                .isEqualTo("Product successfully added to your shopping cart");
        String actualTypePaper = resultSearchPage.getTypePaper();
        softAssert.assertThat(actualTypePaper).as("not as expected" )
                .isEqualTo("Paper Type: Doted");
        String actualQuantity = resultSearchPage.getProductQuantity();
        softAssert.assertThat(actualQuantity).as("not as expected" )
                .isEqualTo("Quantity: 5");
        double actualTotal = resultSearchPage.getTotalPrice();
        double expectedTotal = resultSearchPage.getProductPrice() * 5;
        softAssert.assertThat(actualTotal).as("not as expected")
                .isEqualTo(expectedTotal);
        softAssert.assertAll();

    }
}
