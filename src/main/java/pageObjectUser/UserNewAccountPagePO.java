package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserNewAcountPageUI;

public class UserNewAccountPagePO extends AbtractPage{
	WebDriver driver;

	public UserNewAccountPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerIdTextbox(String customerid) {
		waitToElementVisible(driver, UserNewAcountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserNewAcountPageUI.CUSTOMER_ID_TEXTBOX, customerid);
	}

	public void pressTabKey() {
		waitToElementVisible(driver, UserNewAcountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserNewAcountPageUI.CUSTOMER_ID_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public String getErrorMessageCustomerId() {
		waitToElementVisible(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
		return getTextElement(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
	}

	public void inputToInitialDepositTextbox(String initialDeposit) {
		waitToElementVisible(driver, UserNewAcountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		senkeyToElement(driver, UserNewAcountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialDeposit);
	}

	public String getErrorMessageInitialDeposit() {
		waitToElementVisible(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_INITIAL_DEPOSIT_VERIFY);
		return getTextElement(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_INITIAL_DEPOSIT_VERIFY);
	}

	

	public void selecItemInAccountTypeDropDown(String itemValue) {
	    waitToElementClickable(driver, UserNewAcountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, UserNewAcountPageUI.ACCOUNT_TYPE_DROPDOWN, itemValue);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserNewAcountPageUI.SUBMIT_BUTTON);
		clickToElement(driver,  UserNewAcountPageUI.SUBMIT_BUTTON);
	}

	public String getTextAccountID() {
		waitToElementVisible(driver, UserNewAcountPageUI.TEXT_ACCOUNT_ID);
		return getTextElement(driver, UserNewAcountPageUI.TEXT_ACCOUNT_ID);
	}

	public String getAmountDeposit() {
		waitToElementVisible(driver, UserNewAcountPageUI.GET_TEXT_CURRENT_AMOUNT);
		return getTextElement(driver, UserNewAcountPageUI.GET_TEXT_CURRENT_AMOUNT);
	}

	public String getMessageSuccess() {
		waitToElementVisible(driver, UserNewAcountPageUI.GET_TEXT_MESSAGE_SUCCESS);
		return getTextElement(driver, UserNewAcountPageUI.GET_TEXT_MESSAGE_SUCCESS);
	}

	
}
