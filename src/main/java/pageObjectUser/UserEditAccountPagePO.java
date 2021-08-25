package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserEditAccountPageUI;
import pageUIUser.UserEditCustomerPageUI;
import pageUIUser.UserNewAcountPageUI;

public class UserEditAccountPagePO extends AbtractPage{
	WebDriver driver;

	public UserEditAccountPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerID(String customerid) {
		waitToElementVisible(driver, UserEditAccountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserEditAccountPageUI.CUSTOMER_ID_TEXTBOX, customerid);
		
	}

	public String getErrorMessageOfCustomerID() {
		waitToElementVisible(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
		return getTextElement(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
	
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserEditAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver,  UserEditAccountPageUI.SUBMIT_BUTTON);
	}
	public void pressTabKey() {
		waitToElementVisible(driver, UserEditAccountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserEditAccountPageUI.CUSTOMER_ID_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToAccountNoTextbox(String accountno) {
		waitToElementVisible(driver, UserEditAccountPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserEditAccountPageUI.ACCOUNT_NO_TEXTBOX, accountno);
		
		
	}

	public String getErrorMessageOfAccountNo() {
		waitToElementVisible(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
		return getTextElement(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
	
	}
	public void inputToBalanceTextbox(String balance) {
		waitToElementVisible(driver, UserEditAccountPageUI.BALANCE_TEXTBOX);
		senkeyToElement(driver, UserEditAccountPageUI.BALANCE_TEXTBOX, balance);
		
	}

	public String getErrorMessageOfBalance() {
		waitToElementVisible(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_BALANCE_VERIFY);
		return getTextElement(driver, UserEditAccountPageUI.ERROR_MESSAGE_OF_BALANCE_VERIFY);
	
	}

	public void selectItemInAccountTypeDropdown(String itemValue) {
		  waitToElementClickable(driver, UserEditAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
			selectItemInDropdown(driver, UserEditAccountPageUI.ACCOUNT_TYPE_DROPDOWN, itemValue);
		}
	

	public String getTextAccountType() {
		waitToElementVisible(driver, UserEditAccountPageUI.GET_TEXT_ACCOUNT_TYPE_DROPDOWN);
		return getTextElement(driver, UserEditAccountPageUI.GET_TEXT_ACCOUNT_TYPE_DROPDOWN);
	
	}

	
}
