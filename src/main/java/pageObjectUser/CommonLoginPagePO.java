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
		waitToElementVisible(driver, CommonLoginPageUI.TEXT_USER_ID);	
		return getTextElement(driver, CommonLoginPageUI.TEXT_USER_ID);
	}

	public String getTextPassword() {
		waitToElementVisible(driver, CommonLoginPageUI.TEXT_PASSWORD);	
		return getTextElement(driver, CommonLoginPageUI.TEXT_PASSWORD);
	}

	public UserManagerPagePO loginToSystem(String userid, String password) {
		waitToElementVisible(driver, CommonLoginPageUI.USER_ID_TEXTBOX);
		senkeyToElement(driver,  CommonLoginPageUI.USER_ID_TEXTBOX, userid);
		waitToElementVisible(driver, CommonLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver,  CommonLoginPageUI.PASSWORD_TEXTBOX, password);
		waitToElementClickable(driver, CommonLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  CommonLoginPageUI.LOGIN_BUTTON);
		return PageGenerator. getManagerPage(driver);
	}
}
