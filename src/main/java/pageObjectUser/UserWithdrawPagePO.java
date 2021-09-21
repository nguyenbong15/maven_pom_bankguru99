package pageObjectUser;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserDepositPageUI;
import pageUIUser.UserWithdrawPageUI;

public class UserWithdrawPagePO extends AbtractPage {
	WebDriver driver;

	public UserWithdrawPagePO(WebDriver driver) {
		this.driver = driver;
	}


	public void inputToAccountNoTextbox(String accountId) {
		waitToElementVisible(driver, UserWithdrawPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserWithdrawPageUI.ACCOUNT_NO_TEXTBOX, accountId);
	}

	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, UserWithdrawPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, UserWithdrawPageUI.AMOUNT_TEXTBOX, amount);
	}

	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, UserWithdrawPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, UserWithdrawPageUI.DESCRIPTION_TEXTBOX, description);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserWithdrawPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserWithdrawPageUI.SUBMIT_BUTTON);
	}

	public String getTextTitlePage() {
		waitToElementVisible(driver, UserWithdrawPageUI.TEXT_TITEl_TABLE);
		return getTextElement(driver, UserWithdrawPageUI.TEXT_TITEl_TABLE);
	}

	public String getTextCurrentAmount() {
		waitToElementVisible(driver, UserWithdrawPageUI.TEXT_CURRENT_AMOUNT);
		return getTextElement(driver, UserWithdrawPageUI.TEXT_CURRENT_AMOUNT);
	}


}
