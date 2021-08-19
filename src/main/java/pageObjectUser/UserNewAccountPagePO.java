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

	public Object getErrorMessageInitialDeposit() {
		waitToElementVisible(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_INITIAL_DEPOSIT_VERIFY);
		return getTextElement(driver, UserNewAcountPageUI.ERROR_MESSAGE_OF_INITIAL_DEPOSIT_VERIFY);
	}

	
}
