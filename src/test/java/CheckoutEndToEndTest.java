import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.ResultSearchPage;

public class CheckoutEndToEndTest extends BaseTest {
    @Test
    public void checkoutEndToEnd() {
        MainPage mainPage = new MainPage();
        ResultSearchPage resultSearchPage = new ResultSearchPage();
        SoftAssert softAssert = new SoftAssert();
        String firstName = "Ivan";//RandomStringUtils.randomAlphabetic(5);
        String lastName = "Ivanov";//RandomStringUtils.randomAlphabetic(7);
        String email = "asd@example.com";//RandomStringUtils.randomAlphabetic(10) + "@example.com";
        String address = "asfdfg";//RandomStringUtils.randomAlphabetic(5);
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
        softAssert.assertEquals(actualTotal, expectedTotal);
        resultSearchPage.clickButtonProceedToCheckout()
                .fillRegistrationFormWithValidDataWithoutPasswordAndCheckAllNecessaryCheckboxes(firstName, lastName, email)
                .clickButtonContinue()
                .fillAddressFormWithValidData(address, zipCode, city)
                .setSelectCountry("France")
                .clickButtonContinueAddresses()
                .clickButtonContinueAddresses()
                .clickInputMyCarrier();
        softAssert.assertAll();
    }
}