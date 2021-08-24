package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserCustomisedStatementPageUI;

public class UserCustomisedStatementPagePO extends AbtractPage{
	WebDriver driver;

	public UserCustomisedStatementPagePO(WebDriver driver) {
		this.driver = driver;
	}

	
	public void pressTabKey() {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.MINIMUN_TRANSACTION_TEXTBOX);
		senkeyToElement(driver, UserCustomisedStatementPageUI.MINIMUN_TRANSACTION_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}
	public void inputToAccountNoTextbox(String accountno) {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserCustomisedStatementPageUI.ACCOUNT_NO_TEXTBOX, accountno);
	}

	public String getErrorMessageOfAccountNo() {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
		return getTextElement(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
	}


	public void inputToMinimumTransactionTextbox(String miniumTransaction) {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.MINIMUN_TRANSACTION_TEXTBOX);
		senkeyToElement(driver, UserCustomisedStatementPageUI.MINIMUN_TRANSACTION_TEXTBOX, miniumTransaction);
	}
	
	
	public String getErrorMessageOfMinimumTransaction() {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_MINIMUN_TRANSACTION_VERIFY);
		return getTextElement(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_MINIMUN_TRANSACTION_VERIFY);
	}
	
	public void inputToNumberOfTransectionTextbox(String numberTransaction) {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
		senkeyToElement(driver, UserCustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX, numberTransaction);
	}


	public String getErrorMessageOfNumberOfTransection() {
		waitToElementVisible(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_NUMBER_OF_TRANSACTION_VERIFY);
		return getTextElement(driver, UserCustomisedStatementPageUI.ERROR_MESSAGE_OF_NUMBER_OF_TRANSACTION_VERIFY);
	}

	
}
