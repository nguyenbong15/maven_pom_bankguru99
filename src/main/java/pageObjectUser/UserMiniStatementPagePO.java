package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserEditAccountPageUI;
import pageUIUser.UserMiniStatementPageUI;

public class UserMiniStatementPagePO extends AbtractPage{
	WebDriver driver;

	public UserMiniStatementPagePO(WebDriver driver) {
		this.driver = driver;
	}

	
	public void pressTabKey() {
		waitToElementVisible(driver, UserMiniStatementPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserMiniStatementPageUI.ACCOUNT_NO_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToAccountNoTextbox(String accountno) {
		waitToElementVisible(driver, UserMiniStatementPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserMiniStatementPageUI.ACCOUNT_NO_TEXTBOX, accountno);
		
		
	}

	public String getErrorMessageOfAccountNo() {
		waitToElementVisible(driver, UserMiniStatementPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
		return getTextElement(driver, UserMiniStatementPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
	
	}
	

	
}
