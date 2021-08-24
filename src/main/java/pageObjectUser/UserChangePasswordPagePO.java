package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserChangePasswordPageUI;
import pageUIUser.UserNewCustomerPageUI;

public class UserChangePasswordPagePO extends AbtractPage{
	WebDriver driver;

	public UserChangePasswordPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void pressTabKey() {
		waitToElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	public void inputToOdlPasswordTextbox(String oldPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public String getErrorMessageOfOldPassword() {
		waitToElementVisible(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_OLD_PASSWORD_VERIFY);
		return getTextElement(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_OLD_PASSWORD_VERIFY);
	
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX,newPassword);
	}

	public String getErrorMessageOfNewPassword() {
		waitToElementVisible(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_NEW_PASSWORD_VERIFY);
		return getTextElement(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_NEW_PASSWORD_VERIFY);
	
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
	}

	public String getErrorMessageOfConfirmPassword() {
		waitToElementVisible(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_CONFIRM_PASSWORD_VERIFY);
		return getTextElement(driver, UserChangePasswordPageUI.ERROR_MESSAGE_OF_CONFIRM_PASSWORD_VERIFY);
	
	}

	
}
