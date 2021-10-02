package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserChangePasswordPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_09_Change_Password_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserChangePasswordPagePO changePassword;
    UserManagerPagePO managerPage;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage=PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage=loginPage.loginToSystem("mngr348463","nUsajEh");
	}	
	@Test
	public void TC_01_Old_Password_With_Empty_Data() {
		log.info("Step-01: open change password  page");
		changePassword=managerPage.openChangePasswordPage(driver);
		
		log.info("Step-02: input to old password textbox with empty data");
		changePassword.inputToOdlPasswordTextbox("");
		
		log.info("Step-03: press key tab");
		changePassword.pressTabKey();
		
		log.info("Step-04: verify error message 'Old Password must not be blank' displayed");
		verifyEquals(changePassword.getErrorMessageOfOldPassword(), "Old Password must not be blank");
	}
	@Test
	public void TC_02_New_Password_With_Empty_Data() {
		
		log.info("Step-01: input to new password textbox with empty data");
		changePassword.inputToNewPasswordTextbox("");
		
		log.info("Step-02: press key tab");
		changePassword.pressTabKey();
		
		log.info("Step-03: verify error message 'New Password must not be blank' displayed");
		verifyEquals(changePassword.getErrorMessageOfNewPassword(), "New Password must not be blank");
	}
	
	@Test
	public void TC_03_New_Password_With_Have_Not_Number() {
		
		log.info("Step-01: input to new password textbox with have not number");
		changePassword.inputToNewPasswordTextbox("dbc@");
		
		log.info("Step-02: verify error message 'Enter at-least one numeric value' displayed");
		verifyEquals(changePassword.getErrorMessageOfNewPassword(), "Enter at-least one numeric value");
	}
	
	@Test
	public void TC_04_New_Password_With_Have_Not_Special_Character() {
		
		log.info("Step-01: input to new password textbox with have not special Character");
		changePassword.inputToNewPasswordTextbox("dbc1");
		
		log.info("Step-02: verify error message 'Enter at-least one special character' displayed");
		verifyEquals(changePassword.getErrorMessageOfNewPassword(), "Enter at-least one special character");
	}
	
	@Test
	public void TC_05_New_Password_With_Have_String_Password_Or_password() {
		
		log.info("Step-01: input to new password textbox with have string 'password' or 'Password'");
		changePassword.inputToNewPasswordTextbox("d@1password");
		
		log.info("Step-02: verify error message 'Choose a difficult Password' displayed");
		verifyEquals(changePassword.getErrorMessageOfNewPassword(), "Choose a difficult Password");
		
		log.info("Step-01: input to new password textbox with have string 'password' or 'Password'");
		changePassword.inputToNewPasswordTextbox("d@1Password");
		
		log.info("Step-02: verify error message 'Choose a difficult Password' displayed");
		verifyEquals(changePassword.getErrorMessageOfNewPassword(), "Choose a difficult Password");
	}
	@Test
	public void TC_05_Confirm_Password_Have_To_Equals_New_Passwor() {
		
		log.info("Step-01: input to new password textbox ");
		changePassword.inputToNewPasswordTextbox("bong1@");
		
		log.info("Step-02: input to confirm password textbox ");
		changePassword.inputToConfirmPasswordTextbox("bong1");
		
		log.info("Step-02: verify error message 'Passwords do not Match' displayed");
		verifyEquals(changePassword.getErrorMessageOfConfirmPassword(), "Passwords do not Match");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




