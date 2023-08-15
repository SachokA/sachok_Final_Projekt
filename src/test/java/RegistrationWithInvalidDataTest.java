import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MainPage;

import static enums.Others.RED;

@Test
public class RegistrationWithInvalidDataTest extends BaseTest {
    public void registrationWithValidData() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        SoftAssert softAssert = new SoftAssert();
        String firstName = "James8";
        String lastName = RandomStringUtils.randomAlphabetic(7);
        String email = RandomStringUtils.randomAlphabetic(10) + "@example.com";
        String password = RandomStringUtils.randomAlphanumeric(10);
        mainPage.clickButtonSignIn()
                .clickNotAccount()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .clickCheckBox()
                .clickButtonSave();

        softAssert.assertEquals(loginPage.isInvalidFieldMustBeRed(),RED.getValue());
        softAssert.assertEquals(loginPage.getMessageAlertInvalidFormat(), "Invalid format.");
        softAssert.assertAll();
    }
}
