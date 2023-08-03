package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ResultSearchPage extends BasePage {
    @FindBy(xpath = "//a[text()='Brown bear notebook']")
    private WebElement brownBearNotebook;

    @FindBy(xpath = "//select[@aria-label='Paper Type']")
    private WebElement selectPaperType;

    @FindBy(xpath = "//i[@class ='material-icons touchspin-up']")
    private WebElement inputQuantityWanted;
    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement buttonAddToCard;

    @FindBy(xpath = "//h4[contains(text(),'Product successfully added to your shopping cart')]")
    private WebElement messageSuccessfully;

    @FindBy(xpath = "//span[@class='paper type']")
    private WebElement typePaper;

    @FindBy(xpath = "//span[@class='product-quantity']")
    private WebElement productQuantity;

    @FindBy(xpath = "//p[@class='product-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//span[@class='value']")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[text()='Customizable mug']")
    private WebElement customizableMug;

    @FindBy(xpath = "//textarea[@class='product-message']")
    private WebElement inputProductMessage;

    @FindBy(xpath = "//button[@name='submitCustomizedData']")
    private WebElement buttonSaveCustomized;

    @FindBy(xpath = "//button[text()='Continue shopping']")
    private WebElement buttonContinueShopping;

    @FindBy(xpath = "//input[@name='s']")
    private WebElement inputSearch;

    @FindBy(xpath = "//a[text()='Hummingbird printed t-shirt']")
    private WebElement tShirtHummingbirdPrinted;

    @FindBy(xpath = "//input[@title='Black']")
    private WebElement tShirtHummingbirdPrintedBlackColour;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    private WebElement buttonProceedToCheckout;

    @FindBy(xpath = "//span[@class='current-price-value']")
    private WebElement currentPriceValue;

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']//span[@class='value']")
    private WebElement currentTotalPrice;

    @FindBy(xpath = "//span[@class='product-price']")
    private List<WebElement> currentPrice;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement inputCheckBoxIAgree;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement inputCheckBoxCustomerPrivacy;

    @FindBy(xpath = "//footer[@class='form-footer clearfix']//button[@name='continue']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//input[@id='field-address1']")
    private WebElement inputFieldAddress;

    @FindBy(xpath = "//input[@id='field-postcode']")
    private WebElement inputFieldPostcode;

    @FindBy(xpath = "//input[@id='field-city']")
    private WebElement inputFieldCity;

    @FindBy(xpath = "//*[@id='customer-form']/footer/button")
    private WebElement buttonContinueAddresses;

    @FindBy(xpath = "//input[@id='delivery_option_2']")
    private WebElement inputMyCarrier;

    @FindBy(xpath = "//select[@id='field-id_country']")
    private WebElement selectCountry;
    @FindBy(xpath = "//input[@name='use_same_address']")
    private WebElement inputUseSameAddress;

    public ResultSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ResultSearchPage clickBrownBearNotebook() {
        log.info("Click brown bear notebook");
        brownBearNotebook.click();
        return this;
    }

    public ResultSearchPage select(String value) {
        log.info("Select value");
        Select select = new Select(selectPaperType);
        select.selectByVisibleText(value);
        return this;
    }


    public ResultSearchPage setInputQuantityWanted() {
        log.info("Set input quantity you wanted(5)");
        int clickCounter = 0;

        for (int i = 1; i < 5; i++) {
            inputQuantityWanted.click();
            clickCounter++;
        }

        if (clickCounter == 4) {
            buttonAddToCard.click();
            clickCounter = 0; // Скидаємо лічильник для наступного разу
        }
        return this;
    }

    public String getMessageSuccessfully() {
        log.info("Get message successfully");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageSuccessfully));
        return messageSuccessfully.getText().substring(1);
    }

    public String getTypePaper() {
        log.info("Getting type paper");
        return typePaper.getText();
    }

    public String getProductQuantity() {
        log.info("Get product quantity");
        return productQuantity.getText();
    }

    public double getProductPrice() {
        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public double getTotalPrice() {
        log.info("Get total price");
        return Double.parseDouble(totalPrice.getText().substring(1));
    }

    public ResultSearchPage clickCustomizableMug() {
        customizableMug.click();
        return this;
    }

    public ResultSearchPage setInputProductMessage() {
        inputProductMessage.sendKeys("Best mug ever");
        return this;
    }

    public ResultSearchPage clickButtonCustomizedData() {
        buttonSaveCustomized.click();
        return this;
    }

    public ResultSearchPage clickAddToCard() {
        buttonAddToCard.click();
        return this;
    }

    public ResultSearchPage clickButtonContinueShopping() {
        waitUntilPresent(buttonContinueShopping, 10);
        buttonContinueShopping.click();
        return this;
    }

    public ResultSearchPage setFieldSearch(String string) {
        waitUntilPresent(inputSearch, 10);
        inputSearch.sendKeys(string);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public ResultSearchPage clickTShirtHummingbirdPrinted() {
        tShirtHummingbirdPrinted.click();
        return this;
    }

    public ResultSearchPage clickTShirtHummingbirdPrintedBlackColour() {
        tShirtHummingbirdPrintedBlackColour.click();
        return this;
    }

    public ResultSearchPage clickButtonProceedToCheckout() {
        waitUntilPresent(buttonProceedToCheckout, 10);
        buttonProceedToCheckout.click();
        return this;
    }

    public double getCurrentPriceValue() {
        return Double.parseDouble(currentPriceValue.getText().substring(1));
    }

    public Double getCurrentTotalPriceValue() {
        return Double.valueOf(currentTotalPrice.getText().substring(1));
    }

    public double getTotalPriceAllProducts() {
        List<Double> list = new ArrayList<>();
        List<WebElement> prices = currentPrice;
        double total = 0.00;
        for (WebElement webElement : prices) {
            list.add(Double.valueOf((webElement.getText().substring(1))));
            total = total + list.get(list.size() - 1);
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public ResultSearchPage fillRegistrationFormWithValidDataWithoutPasswordAndCheckAllNecessaryCheckboxes(String firstName, String lastName, String email) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputCheckBoxIAgree.click();
        inputCheckBoxCustomerPrivacy.click();
        return this;
    }

    public ResultSearchPage clickButtonContinue() {
        buttonContinue.click();
        return this;
    }

    public void clickButtonContinueAddresses() {
      //  Actions actions = new Actions(getDriver());
//        waitUntilPresent(buttonContinueAddresses,10);
//        actions.moveToElement(buttonContinueAddresses);
//        actions.click();
//        actions.perform();

        buttonContinueAddresses.click();
    }

    public ResultSearchPage moveToAndClickButtonContinueAddresses() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(buttonContinueAddresses).click().perform();
        return this;
    }

    public ResultSearchPage fillAddressFormWithValidData(String address, String zipCode, String city) {
        inputFieldAddress.sendKeys(address);
        inputFieldPostcode.sendKeys(zipCode);
        inputFieldCity.sendKeys(city);
        return this;
    }

    public void clickInputMyCarrier() {
        waitUntilPresent(inputMyCarrier, 10);
        inputMyCarrier.click();


    }

    public void setSelectCountry(String value) {
        Select select = new Select(selectCountry);
        select.selectByVisibleText(value);
    }

    public void clickUseThisAddress(){
        inputUseSameAddress.click();
    }
}
