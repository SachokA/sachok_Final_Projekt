import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class RegistrationWithValidDataTest extends BaseTest{
@Test
    public void registrationWithValidData(){
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    String firstName = RandomStringUtils.randomAlphabetic(5);
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

    String randomUserName = firstName + " " + lastName;
    Assert.assertEquals(loginPage.getDisplayedUserName(),randomUserName);
}
}
