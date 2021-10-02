package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserDeleteAccountPageUI;

public class UserDeleteAccountPagePO extends AbtractPage {
	WebDriver driver;

	public UserDeleteAccountPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabKey() {
		waitToElementVisible(driver, UserDeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserDeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToAccountNoTextbox(String accountno) {
		waitToElementVisible(driver, UserDeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserDeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, accountno);

	}

	public String getErrorMessageOfAccountNo() {
		waitToElementVisible(driver, UserDeleteAccountPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);
		return getTextElement(driver, UserDeleteAccountPageUI.ERROR_MESSAGE_OF_ACCOUNT_NO_VERIFY);

	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserDeleteAccountPageUI.SUBMIT_BUTTON);
        clickToElement(driver, UserDeleteAccountPageUI.SUBMIT_BUTTON);
	}

}