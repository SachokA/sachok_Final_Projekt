package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import untils.Utils;

import java.util.List;

import static untils.Utils.waitSeconds;

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

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> inputCheckBoxIAgree;

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

    public LoginPage setFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public LoginPage setLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public LoginPage setEmail(String Email) {
        inputEmail.sendKeys(Email);
        return this;
    }

    public LoginPage setPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickCheckBox() {
        List<WebElement> checkBoxs = inputCheckBoxIAgree;
        for (WebElement check : checkBoxs) {
            check.click();
        }
        return this;
    }

    public LoginPage clickButtonSave() {
        buttonSave.click();
        return this;
    }

    public String getDisplayedUserName() {
        log.info("Get displayed user name");
        waitSeconds(2);
        return showedCurrentlyUser.getText();
    }

    public String getMessageAlertInvalidFormat() {
        log.info("Getting message alert invalid format");
        return alertInvalidFormat.getText();
    }

    public String isInvalidFieldMustBeRed() {
        log.info("Is invalid field must be red");
        String style = inputFirstName.getCssValue("outline-color");
        return style;
    }
}
