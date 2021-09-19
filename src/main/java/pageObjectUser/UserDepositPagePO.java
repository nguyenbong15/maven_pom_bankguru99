package pageObjectUser;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserDepositPageUI;

public class UserDepositPagePO extends AbtractPage {
	WebDriver driver;

	public UserDepositPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAccountNoTextbox(String accountId) {
		waitToElementVisible(driver, UserDepositPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, UserDepositPageUI.ACCOUNT_NO_TEXTBOX, accountId);
	}

	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, UserDepositPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, UserDepositPageUI.AMOUNT_TEXTBOX, amount);
	}

	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, UserDepositPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, UserDepositPageUI.DESCRIPTION_TEXTBOX, description);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserDepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserDepositPageUI.SUBMIT_BUTTON);
	}

	public String getTextTitlePage() {
		waitToElementVisible(driver, UserDepositPageUI.TEXT_TITEl_TABLE);
		return getTextElement(driver, UserDepositPageUI.TEXT_TITEl_TABLE);
	}

	public String getTextCurrentAmount() {
		waitToElementVisible(driver, UserDepositPageUI.TEXT_CURRENT_AMOUNT);
		return getTextElement(driver, UserDepositPageUI.TEXT_CURRENT_AMOUNT);
	}

}
