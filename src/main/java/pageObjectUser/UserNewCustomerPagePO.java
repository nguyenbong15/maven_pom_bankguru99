package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserNewAcountPageUI;
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
	
}
