import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.ResultSearchPage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckoutEndToEndTest extends BaseTest {
    @Test
    public void checkoutEndToEnd() throws InterruptedException {
        MainPage mainPage = new MainPage();
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        SoftAssertions softAssert = new SoftAssertions();
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "agukavchyk@gmail.com";
        String address = "вул.Вежа,12";
        String zipCode = "12345";
        String city = "Париж";
        double actualTotal = mainPage.setFieldSearch("mug")
                .clickCustomizableMug()
                .setInputProductMessage()
                .clickButtonCustomizedData()
                .clickAddToCard()
                .clickButtonContinueShopping()
                .setFieldSearch("T-Shirt")
                .clickTShirtHummingbirdPrinted()
                .clickTShirtHummingbirdPrintedBlackColour()
                .clickAddToCard()
                .clickButtonProceedToCheckout()
                .getCurrentTotalPriceValue();
        System.out.println(actualTotal);
        double expectedTotal = resultSearchPage.getTotalPriceAllProducts();
        softAssert.assertThat(actualTotal).isEqualTo(expectedTotal);
        double actualAmount = resultSearchPage
                .clickButtonProceedToCheckout()
                .fillRegistrationFormWithValidDataWithoutPasswordAndCheckAllNecessaryCheckboxes(firstName, lastName, email)
                .clickButtonContinue()
                .fillAddressFormWithValidData(address, zipCode, city)
                .setSelectCountry("France")
                .clickButtonContinueAddresses()
                .clickInputMyCarrier()
                .clickContinueShippingMethod()
                .clickPayByCheck()
                .getAmount();

        double subTotal = resultSearchPage.getSubTotal();
        double shipping = resultSearchPage.getShipping();
        BigDecimal expectedAmount = new BigDecimal(subTotal).add(new BigDecimal(shipping)).setScale(2, RoundingMode.HALF_UP);
        softAssert.assertThat(actualAmount).isEqualTo(expectedAmount.doubleValue());
        String actualMessageYourOrderedIsConfirmed = resultSearchPage
                .clickIAgree()
                .clickPlaceOrder()
                .getMessageYourOrderedIsConfirmed();
        softAssert.assertThat(actualMessageYourOrderedIsConfirmed)
                .isEqualTo("YOUR ORDER IS CONFIRMED");
        BigDecimal actualTotalLast = BigDecimal.valueOf(resultSearchPage.getTotalLast());
        softAssert.assertThat(actualTotalLast).isEqualTo(expectedAmount);

        softAssert.assertAll();
    }
}
