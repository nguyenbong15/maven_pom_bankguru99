package pageObjectUser;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.CommonLoginPageUI;

public class CommonLoginPagePO extends AbtractPage{
	WebDriver driver;

	public CommonLoginPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToHereVisitLink() {
		waitToElementClickable(driver, CommonLoginPageUI.HERE_VISIT_LINK);
		clickToElement(driver,  CommonLoginPageUI.HERE_VISIT_LINK);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, CommonLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver,  CommonLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, CommonLoginPageUI.SUBMIT_BUTTON);
		clickToElement(driver,  CommonLoginPageUI.SUBMIT_BUTTON);
	}

	public String getTextUserId() {
		waitToElementVisible(driver, CommonLoginPageUI.USER_ID_TEXT);	
		return getTextElement(driver, CommonLoginPageUI.USER_ID_TEXT);
	}

	public String getTextPassword() {
		waitToElementVisible(driver, CommonLoginPageUI.PASSWORD_TEXT);	
		return getTextElement(driver, CommonLoginPageUI.PASSWORD_TEXT);
	}
}
