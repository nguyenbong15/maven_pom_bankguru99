package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserNewCustomerPageUI;

public class UserNewCustomerPagePO extends AbtractPage{
	WebDriver driver;

	public UserNewCustomerPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabKey() {
		waitToElementVisible(driver, UserNewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.CUSTOMER_NAME_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToCustomerName(String customerName) {
		waitToElementVisible(driver, UserNewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
		
	}

	public String getErrorMessageOfAddress() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_ADDRESS_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_ADDRESS_VERIFY);
	}

	public String getErrorMessageOfCustomerName() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_NAME_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_NAME_VERIFY);
	}

	public void inputToAddressTextbox(String address) {
		waitToElementVisible(driver, UserNewCustomerPageUI.ADDRESS_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.ADDRESS_TEXTBOX, address);
	}

	public void inputToCityTextbox(String city) {
		waitToElementVisible(driver, UserNewCustomerPageUI.CITY_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.CITY_TEXTBOX, city);
	}

	public String getErrorMessageOfCity() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_CITY_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_CITY_VERIFY);
	}

	public void inputToStateTextBox(String state) {
		waitToElementVisible(driver, UserNewCustomerPageUI.STATE_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void pressKeyTabStateFiled() {
		waitToElementVisible(driver, UserNewCustomerPageUI.STATE_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
	}

	public String getErrorMessageOfState() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_STATE_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_STATE_VERIFY);
	}

	public void inputToPinTextbox(String pin) {
		waitToElementVisible(driver, UserNewCustomerPageUI.PIN_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.PIN_TEXTBOX, pin);
	}
	public String getErrorMessageOfPin() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_PIN_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_PIN_VERIFY);
	}
	public void inputToMobilePhoneTextbox(String phoneNumber) {
		waitToElementVisible(driver, UserNewCustomerPageUI.MOBILE_PHONE_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.MOBILE_PHONE_TEXTBOX, phoneNumber);
	}
	
	public String getErrorMessageOfMobilePhone() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_MOBILE_PHONE_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_MOBILE_PHONE_VERIFY);
	}
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserNewCustomerPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageOfEmail() {
		waitToElementVisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
		return getTextElement(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
	}

	public boolean isErrorMessagedisplayed() {
		waitToElementInvisible(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
		return isElementDisplayed(driver, UserNewCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
	}

	public void clickToSubmitbutton() {
		waitToElementClickable(driver, UserNewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserNewCustomerPageUI.SUBMIT_BUTTON);
	}

	public void inputToDateOfBirth(String dateOfBirth) {
		waitToElementVisible(driver, UserNewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void clickToGenderMaleRadio() {
			waitToElementClickable(driver, UserNewCustomerPageUI.MALE_RADIO);
			clickToElement(driver, UserNewCustomerPageUI.MALE_RADIO);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserNewCustomerPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserNewCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	
	public String getTextMeassageSuccess() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_MESSAGE_SUCCESS);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_MESSAGE_SUCCESS);
	
	}
    public String getCustomerId() {
		waitToElementVisible(driver, UserNewCustomerPageUI.CUSTOMER_ID_TEXT);
		return getTextElement(driver, UserNewCustomerPageUI.CUSTOMER_ID_TEXT);
	
	}

	public String getTextCustomerName() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_CUSTOMER_NAME);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_CUSTOMER_NAME);
	
	}

	public String getTextGender() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_GENDER);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_GENDER);
	}

	public String getTextAddress() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_ADDRESS);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_ADDRESS);
	
	}

	public String getTextCity() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_CITY);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_CITY);
	
	}

	public String getTextState() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_STATE);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_STATE);
	
	}

	public String getTextPhoneNumber() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_MOBILE_NUMBER);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_MOBILE_NUMBER);
	
	}

	public String getTextPin() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_PIN);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_PIN);
	
	}

	public String getTextEmail() {
		waitToElementVisible(driver, UserNewCustomerPageUI.GET_TEXT_EMAIL);
		return getTextElement(driver, UserNewCustomerPageUI.GET_TEXT_EMAIL);
	
	}
	
}
