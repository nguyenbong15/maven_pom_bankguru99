package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserChangePasswordPageUI;
import pageUIUser.UserFundTransferPageUI;
import pageUIUser.UserWithdrawPageUI;

public class UserFundTransferPagePO extends AbtractPage{
	WebDriver driver;

	public UserFundTransferPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabKey() {
		waitToElementVisible(driver, UserFundTransferPageUI.PAYER_ACCOUNT_TEXTBOX);
		senkeyToElement(driver, UserFundTransferPageUI.PAYER_ACCOUNT_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}


	public void inputToPayerAccountTextbox(String payerAccount) {
		waitToElementVisible(driver, UserFundTransferPageUI.PAYER_ACCOUNT_TEXTBOX);
		senkeyToElement(driver, UserFundTransferPageUI.PAYER_ACCOUNT_TEXTBOX,payerAccount);
	}
	public String getErrorMessageOfPayerAccount() {
		waitToElementVisible(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_PAYER_ACCOUNT_VERIFY);
		return getTextElement(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_PAYER_ACCOUNT_VERIFY);
	
	}

	public void inputToPayeesAccountTextbox(String payeesAccount) {
		waitToElementVisible(driver, UserFundTransferPageUI.PAYEES_ACCOUNT_TEXTBOX);
		senkeyToElement(driver, UserFundTransferPageUI.PAYEES_ACCOUNT_TEXTBOX,payeesAccount);
	}

	public String getErrorMessageOfPayeesAccount() {
		waitToElementVisible(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_PAYEES_ACCOUNT_VERIFY);
		return getTextElement(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_PAYEES_ACCOUNT_VERIFY);
	
	}
	public void inputToAmountTextbox(String amount) {
		
		waitToElementVisible(driver, UserFundTransferPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, UserFundTransferPageUI.AMOUNT_TEXTBOX,amount);
	
	}

	public String getErrorMessageOfAmount() {
		waitToElementVisible(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_AMOUNT_VERIFY);
		return getTextElement(driver, UserFundTransferPageUI.ERROR_MESSAGE_OF_AMOUNT_VERIFY);
	
	}
	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserFundTransferPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserFundTransferPageUI.SUBMIT_BUTTON);
	}

	public String getTextTitlePage() {
		waitToElementVisible(driver, UserFundTransferPageUI.TEXT_TITEl_TABLE);
		return getTextElement(driver, UserFundTransferPageUI.TEXT_TITEl_TABLE);
	}

	public String getTextAmount() {
		waitToElementVisible(driver, UserFundTransferPageUI.TEXT_CURRENT_AMOUNT);
		return getTextElement(driver, UserFundTransferPageUI.TEXT_CURRENT_AMOUNT);
	}

	public void inputToDescriptionTextbox(String string) {
		
		waitToElementVisible(driver, UserFundTransferPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, UserFundTransferPageUI.DESCRIPTION_TEXTBOX,string);
		
	}

	


	
}
