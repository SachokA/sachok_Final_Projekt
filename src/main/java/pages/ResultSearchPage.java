package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import untils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static untils.Utils.waitSeconds;


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

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> inputCheckBox;

    @FindBy(xpath = "//button[@name='continue']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//input[@id='field-address1']")
    private WebElement inputFieldAddress;

    @FindBy(xpath = "//input[@id='field-postcode']")
    private WebElement inputFieldPostcode;

    @FindBy(xpath = "//input[@id='field-city']")
    private WebElement inputFieldCity;

    @FindBy(xpath = "//button[@name='confirm-addresses']")//"//*[@id='customer-form']/footer/button")
    private WebElement buttonContinueAddresses;

    @FindBy(xpath = "//input[@id='delivery_option_2']")
    private WebElement inputMyCarrier;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement continueShippingMethod;

    @FindBy(xpath = "//select[@id='field-id_country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='payment-option-3']")
    private WebElement inputCheckByPay;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement inputIAgree;

    @FindBy(xpath = "//*[@id='cart-subtotal-products']/span[2]")
    private WebElement subTotal;

    @FindBy(xpath = "//*[@id='cart-subtotal-shipping']/span[2]")
    private WebElement subTotalShipping;

    @FindBy(xpath = "//*[@id='payment-option-3-additional-information']/section/dl/dd[1]")
    private WebElement amount;

    @FindBy(xpath = "//button[contains(text(),'Place order')]")
    private WebElement placeOrder;

    @FindBy(xpath = "//h3[@class = 'h1 card-title']")
    private WebElement messageYourOrderIsConfirmed;

    @FindBy(xpath = "//*[@id='order-items']/div[2]/table/tbody/tr[3]/td[2]")
    private WebElement totalLast;


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
        waitSeconds(1);
        for (int i = 1; i < 5; i++) {
            inputQuantityWanted.click();
            clickCounter++;
        }

        if (clickCounter == 4) {
            buttonAddToCard.click();
            clickCounter = 0;
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
        log.info("Click Customizable Mug");
        customizableMug.click();
        return this;
    }

    public ResultSearchPage setInputProductMessage() {
        log.info("Set input product message");
        inputProductMessage.sendKeys("Best mug ever");
        return this;
    }

    public ResultSearchPage clickButtonCustomizedData() {
        log.info("Click button customized data");
        buttonSaveCustomized.click();
        return this;
    }

    public ResultSearchPage clickAddToCard() {
        log.info("click add to card");
        buttonAddToCard.click();
        return this;
    }

    public ResultSearchPage clickButtonContinueShopping() {
        log.info("Click button continue shopping");
        waitUntilPresent(buttonContinueShopping, 10);
        buttonContinueShopping.click();
        return this;
    }

    public ResultSearchPage setFieldSearch(String string) {
        log.info("Setting field search and click ENTER");
        waitUntilPresent(inputSearch, 10);
        inputSearch.sendKeys(string);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public ResultSearchPage clickTShirtHummingbirdPrinted() {
        log.info("Click T-shirt Humming printed");
        tShirtHummingbirdPrinted.click();
        return this;
    }

    public ResultSearchPage clickTShirtHummingbirdPrintedBlackColour() {
        log.info("Choice of colour T-Shirt black");
        tShirtHummingbirdPrintedBlackColour.click();
        return this;
    }

    public ResultSearchPage clickButtonProceedToCheckout() {
        log.info("click Button Proceed To Checkout");
        waitUntilPresent(buttonProceedToCheckout, 10);
        buttonProceedToCheckout.click();
        return this;
    }

    public Double getCurrentTotalPriceValue() {
        log.info("get Current Total Price Value");
        return Double.valueOf(currentTotalPrice.getText().substring(1));
    }

    public double getTotalPriceAllProducts() {
        log.info("get Total Price All Products");
        List<Double> list = new ArrayList<>();
        List<WebElement> prices = currentPrice;
        double total = 0.00;
        for (WebElement webElement : prices) {
            list.add(Double.valueOf((webElement.getText().substring(1))));
            total = total + list.get(list.size() - 1);
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public ResultSearchPage setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public ResultSearchPage setInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public ResultSearchPage setInputEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public ResultSearchPage clickInputCheckBox() {
        List<WebElement> checkBoxs = inputCheckBox;
        for (WebElement check : checkBoxs) {
            check.click();
        }
        return this;
    }

    public ResultSearchPage clickButtonContinue() {
        log.info("Click Button Continue");
        buttonContinue.click();
        return this;
    }

    public ResultSearchPage clickButtonContinueAddresses() {
        log.info("Click Button Continue Addresses");
        waitSeconds(3);
        buttonContinueAddresses.click();
        return this;
    }

    public ResultSearchPage setInputFileAddress(String address) {
        inputFieldAddress.sendKeys(address);
        return this;
    }

    public ResultSearchPage setInputFieldPostcode(String zipCode) {
        waitSeconds(1);
        inputFieldPostcode.sendKeys(zipCode);
        return this;
    }

    public ResultSearchPage setInputFieldCity(String city) {
        waitSeconds(1);
        inputFieldCity.sendKeys(city);
        return this;
    }

    public ResultSearchPage clickInputMyCarrier() {
        log.info("click Input My Carrier");
        waitSeconds(2);
        inputMyCarrier.click();
        return this;
    }

    public ResultSearchPage clickContinueShippingMethod() {
        log.info("click Continue Shipping Method");
        continueShippingMethod.click();
        return this;
    }

    public ResultSearchPage setSelectCountry(String value) {
        log.info("set Select Country");
        Select select = new Select(selectCountry);
        select.selectByVisibleText(value);
        return this;
    }

    public ResultSearchPage clickPayByCheck() {
        log.info("click Pay By Check");
        waitSeconds(1);
        inputCheckByPay.click();
        return this;
    }

    public ResultSearchPage clickIAgree() {
        log.info("click I Agree...");
        inputIAgree.click();
        return this;
    }

    public double getSubTotal() {
        log.info("Get subtotal");
        return Double.parseDouble(subTotal.getText().substring(1));
    }

    public double getShipping() {
        log.info("Get Shipping");
        return Double.parseDouble(subTotalShipping.getText().substring(1));
    }

    public Double getAmount() {
        log.info("get Amount");
        String amountText = amount.getText();
        BigDecimal amountValue = new BigDecimal(amountText.substring(1, 6));
        return amountValue.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public ResultSearchPage clickPlaceOrder() {
        log.info("click Place Order");
        waitSeconds(1);
        placeOrder.click();
        return this;
    }

    public String getMessageYourOrderedIsConfirmed() {
        waitSeconds(1);
        return messageYourOrderIsConfirmed.getText().substring(1);
    }

    public double getTotalLast() {
        return Double.parseDouble(totalLast.getText().substring(1));
    }
}
