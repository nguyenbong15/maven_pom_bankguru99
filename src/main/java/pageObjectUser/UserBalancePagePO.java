package pageObjectUser;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserBalancePageUI;

public class UserBalancePagePO extends AbtractPage {
	WebDriver driver;

	public UserBalancePagePO(WebDriver driver) {
		this.driver = driver;
	}


	public void inputToAccountNoTextbox(String accountId) {
		waitToElementVisible(driver, UserBalancePageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserBalancePageUI.ACCOUNT_NO_TEXTBOX, accountId);
	}

	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, UserBalancePageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, UserBalancePageUI.AMOUNT_TEXTBOX, amount);
	}

	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, UserBalancePageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, UserBalancePageUI.DESCRIPTION_TEXTBOX, description);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserBalancePageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserBalancePageUI.SUBMIT_BUTTON);
	}

	public String getTextTitlePage() {
		waitToElementVisible(driver, UserBalancePageUI.TEXT_TITEl_TABLE);
		return getTextElement(driver, UserBalancePageUI.TEXT_TITEl_TABLE);
	}

	public String getTextCurrentAmount() {
		waitToElementVisible(driver, UserBalancePageUI.TEXT_BALANCE);
		return getTextElement(driver, UserBalancePageUI.TEXT_BALANCE);
	}


}
