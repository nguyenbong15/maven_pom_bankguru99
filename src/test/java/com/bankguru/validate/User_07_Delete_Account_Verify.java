package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserDeleteAccountPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_07_Delete_Account_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserDeleteAccountPagePO deleteAccount;
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
	public void TC_01_Account_No_With_Empty_Data() {
		log.info("Step-01: open edit account page");
		deleteAccount=managerPage.openDeleteAccountPage(driver);
		
		log.info("Step-02: input to account no textbox with empty data");
		deleteAccount.inputToAccountNoTextbox("");
		
		log.info("Step-03: press key tab");
		deleteAccount.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(deleteAccount.getErrorMessageOfAccountNo(), "Account Number must not be blank");
	}
	@Test
	public void TC_02_Account_No_With_Have_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have character data");
		deleteAccount.inputToAccountNoTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(deleteAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	@Test
	public void TC_04_Account_No_With_Special_Character_Data() {
		
		log.info("Step-01: input to account no textbox with special character data");
		deleteAccount.inputToAccountNoTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(deleteAccount.getErrorMessageOfAccountNo(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_05_Account_No_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have space character");
		deleteAccount.inputToAccountNoTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(deleteAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@Test
	public void TC_06_Account_No_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to account no textbox with first character as blank");
		deleteAccount.inputToAccountNoTextbox(" ");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(deleteAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




