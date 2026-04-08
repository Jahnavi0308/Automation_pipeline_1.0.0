package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.SelectClass;
import io.qameta.allure.Step;

public class Homepage extends BasePage {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    //Object Repository
    SelectClass selectClass = new SelectClass();

    //signup login elements
    @FindBy(xpath = "//a[contains(normalize-space(),'Signup / Login')]")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement ENTER_NAME;

    @FindBy(xpath = "//input[@placeholder='Name']/following-sibling::input[@name='email']")
    public WebElement ENTER_EMAIL;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    public WebElement SIGNUP_BUTTON;
   
    //Account Information
    @FindBy(xpath ="//input[contains(@id,'id_gender') and @value = 'Mrs']")
    private WebElement genderMrsRadioButton;

    @FindBy(xpath ="//input[contains(@id,'id_gender') and @value = 'Mr']")
    private WebElement genderMrRadioButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement newUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement newUserPassword;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearsDropdown;
 
    //Address Information
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement address1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement address2;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobilePhone;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountButton;

    @Step("user clicks on login link")
    public void clickLoginLink() {
        waitForElementToBeClickable(loginLink);
        loginLink.click();
    }

    @Step("user clicks on signup button")
    public void clickSignupButton() {
        waitForElementToBeClickable(SIGNUP_BUTTON);
        SIGNUP_BUTTON.click();
    }

    @Step("user enters name")
    public void enterName(String name) {
        waitForElementToBeVisible(ENTER_NAME);
        ENTER_NAME.sendKeys(name);
    }

    @Step("user enters email")
    public void enterEmail(String email) {
        waitForElementToBeVisible(ENTER_EMAIL);
        ENTER_EMAIL.sendKeys(email);
    }

    @Step("user selects female gender")
    public void selectGenderFemale(){
        waitForElementToBeClickable(genderMrsRadioButton);
        genderMrsRadioButton.click();
    }

    @Step("user selects male gender")
    public void selectGenderMale(){
        waitForElementToBeClickable(genderMrRadioButton);
        genderMrRadioButton.click();
    }

    @Step("user enters user name")
    public void enterUserName(String name) {
        waitForElementToBeVisible(newUserName);
        newUserName.sendKeys(name);
    }

    @Step("user enters user password")
    public void enterUserPassword(String password) {
        waitForElementToBeVisible(newUserPassword);
        newUserPassword.sendKeys(password);
    }

    @Step("user selects date of birth")
    public void selectDaysDropdown(String day) {
        selectClass.SelectDropdown(daysDropdown);
        selectClass.selectVisibleText(day);
    }

    @Step("user selects month of birth")
    public void selectMonthsDropdown(String month) {
        selectClass.SelectDropdown(monthsDropdown);
        selectClass.selectVisibleText(month);
    }

    @Step("user selects year of birth")
    public void selectYearsDropdown(String year) {
        selectClass.SelectDropdown(yearsDropdown);
        selectClass.selectVisibleText(year);
    }

    @Step("user enters date of birth")
    public void enterDateOfBirth(String day, String month, String year) {
        waitForElementToBeVisible(daysDropdown);
        selectClass.SelectDropdown(daysDropdown);
        selectClass.selectVisibleText(day);
        
        waitForElementToBeVisible(monthsDropdown);
        selectClass.SelectDropdown(monthsDropdown);
        selectClass.selectVisibleText(month);
        
        waitForElementToBeVisible(yearsDropdown);
        selectClass.SelectDropdown(yearsDropdown);
        selectClass.selectVisibleText(year);
    }

    @Step("user enters first name")
    public void enterFirstName(String firstName) {
        waitForElementToBeVisible(this.firstName);
        this.firstName.sendKeys(firstName);
    }

    @Step("user enters last name")
    public void enterLastName(String lastName) {
        waitForElementToBeVisible(this.lastName);
        this.lastName.sendKeys(lastName);
    }

    @Step("user enters company name")
    public void enterCompany(String company) {
        waitForElementToBeVisible(this.company);
        this.company.sendKeys(company);
    }   

    @Step("user enters address1")
    public void enterAddress1(String address1) {
        waitForElementToBeVisible(this.address1);
        this.address1.sendKeys(address1);
    }

    @Step("user enters address2")
    public void enterAddress2(String address2) {
        waitForElementToBeVisible(this.address2);
        this.address2.sendKeys(address2);
    }

    @Step("user enters country")
    public void enterCountry(String country) {
        waitForElementToBeVisible(this.country);
        selectClass.SelectDropdown(this.country);
        selectClass.selectVisibleText(country);
    }

    @Step("user enters city")
    public void enterCity(String city) {
        waitForElementToBeVisible(this.city);
        this.city.sendKeys(city);
    }

    @Step("user enters state")
    public void enterState(String state) {
        waitForElementToBeVisible(this.state);
        this.state.sendKeys(state);
    }

    @Step("user enters zipcode")
    public void enterZipcode(String zipcode) {
        waitForElementToBeVisible(this.zipcode);
        this.zipcode.sendKeys(zipcode);
    }

    @Step("user enters mobile phone")
    public void enterMobilePhone(String mobilePhone) {
        waitForElementToBeVisible(this.mobilePhone);
        this.mobilePhone.sendKeys(mobilePhone);
    }

    @Step("user clicks on create account button")
    public void clickCreateAccountButton() {
        waitForElementToBeClickable(createAccountButton);
        createAccountButton.click();
    }


}
