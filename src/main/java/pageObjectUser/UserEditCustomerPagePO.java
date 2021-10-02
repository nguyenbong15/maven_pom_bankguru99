package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserEditCustomerPageUI;
import pageUIUser.UserNewCustomerPageUI;

public class UserEditCustomerPagePO extends AbtractPage{
	WebDriver driver;

	public UserEditCustomerPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerID(String customerid) {
		waitToElementVisible(driver, UserEditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerid);
		
	}

	public String getErrorMessageOfCustomerID() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
	
	}

	
	public void pressTabKey() {
		waitToElementVisible(driver, UserEditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.CUSTOMER_ID_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToCustomerName(String customerName) {
		waitToElementVisible(driver, UserEditCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
		
	}

	public String getErrorMessageOfAddress() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_ADDRESS_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_ADDRESS_VERIFY);
	}

	public String getErrorMessageOfCustomerName() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_NAME_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_NAME_VERIFY);
	}

	public void inputToAddressTextbox(String address) {
		waitToElementVisible(driver, UserEditCustomerPageUI.ADDRESS_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.ADDRESS_TEXTBOX, address);
	}

	public void inputToCityTextbox(String city) {
		waitToElementVisible(driver, UserEditCustomerPageUI.CITY_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.CITY_TEXTBOX, city);
	}

	public String getErrorMessageOfCity() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CITY_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_CITY_VERIFY);
	}

	public void inputToStateTextBox(String state) {
		waitToElementVisible(driver, UserEditCustomerPageUI.STATE_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void pressKeyTabStateFiled() {
		waitToElementVisible(driver, UserEditCustomerPageUI.STATE_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
	}

	public String getErrorMessageOfState() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_STATE_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_STATE_VERIFY);
	}

	public void inputToPinTextbox(String pin) {
		waitToElementVisible(driver, UserEditCustomerPageUI.PIN_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.PIN_TEXTBOX, pin);
	}
	public String getErrorMessageOfPin() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_PIN_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_PIN_VERIFY);
	}
	public void inputToMobilePhoneTextbox(String phoneNumber) {
		waitToElementVisible(driver, UserEditCustomerPageUI.MOBILE_PHONE_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.MOBILE_PHONE_TEXTBOX, phoneNumber);
	}
	
	public String getErrorMessageOfMobilePhone() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_MOBILE_PHONE_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_MOBILE_PHONE_VERIFY);
	}
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserEditCustomerPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageOfEmail() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
		return getTextElement(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
	}

	public boolean isErrorMessagedisplayed() {
		waitToElementInvisible(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
		return isElementDisplayed(driver, UserEditCustomerPageUI.ERROR_MESSAGE_OF_EMAIL_VERIFY);
	}

	public void pressTabKeyOfAddress() {
		waitToElementVisible(driver, UserEditCustomerPageUI.ADDRESS_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.ADDRESS_TEXTBOX, Keys.TAB);
	}

	public void pressTabKeyofCity() {
		waitToElementVisible(driver, UserEditCustomerPageUI.CITY_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
	}
	public void inputToDateOfBirth(String dateOfBirth) {
		waitToElementVisible(driver, UserEditCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		senkeyToElement(driver, UserEditCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}
	
	

	public String getTextCustomerName() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_CUSTOMER_NAME);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_CUSTOMER_NAME);
	
	}

	public String getTextGender() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_GENDER);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_GENDER);
	}

	public String getTextAddress() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_ADDRESS);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_ADDRESS);
	
	}

	public String getTextCity() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_CITY);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_CITY);
	
	}

	public String getTextState() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_STATE);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_STATE);
	
	}

	public String getTextPhoneNumber() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_MOBILE_NUMBER);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_MOBILE_NUMBER);
	
	}

	public String getTextPin() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_PIN);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_PIN);
	
	}

	public String getTextEmail() {
		waitToElementVisible(driver, UserEditCustomerPageUI.GET_TEXT_EMAIL);
		return getTextElement(driver, UserEditCustomerPageUI.GET_TEXT_EMAIL);
	
	}

	public void clickToSubmitbutton() {
		waitToElementClickable(driver, UserEditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserEditCustomerPageUI.SUBMIT_BUTTON);
	}

	
}
