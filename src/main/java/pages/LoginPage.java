package pages;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement notAccount;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSave;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement inputCheckBoxIAgree;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement inputCheckBoxCustomerPrivacy;

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    private WebElement showedCurrentlyUser;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement alertInvalidFormat;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickNotAccount() {
        log.info("Clicking button not account");
        notAccount.click();
        return this;
    }

    public LoginPage fillRegistrationFormWithRandomData(String firstName, String lastName, String email, String password) {
        log.info("Filling registration form with random data");
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputCheckBoxIAgree.click();
        inputCheckBoxCustomerPrivacy.click();
        buttonSave.click();
        return this;
    }

    public String getDisplayedUserName() {
        log.info("Get displayed user name");
        return showedCurrentlyUser.getText();
    }
    public String getMessageAlertInvalidFormat(){
        log.info("Getting message alert invalid format");
        return alertInvalidFormat.getText();
    }
    public String isInvalidFieldMustBeRed(){
        log.info("Is invalid field must be red");
        String style = inputFirstName.getCssValue("outline-color");
        return style;
    }
}
