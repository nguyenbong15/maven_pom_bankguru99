package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserMiniStatementPagePO;

public class User_08_Mini_Statement_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserMiniStatementPagePO miniStatement;
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
		miniStatement=managerPage.openMiniStatementPage(driver);
		
		log.info("Step-02: input to account no textbox with empty data");
		miniStatement.inputToAccountNoTextbox("");
		
		log.info("Step-03: press key tab");
		miniStatement.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(miniStatement.getErrorMessageOfAccountNo(), "Account Number must not be blank");
	}
	@Test
	public void TC_02_Account_No_With_Have_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have character data");
		miniStatement.inputToAccountNoTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(miniStatement.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	@Test
	public void TC_03_Account_No_With_Special_Character_Data() {
		
		log.info("Step-01: input to account no textbox with special character data");
		miniStatement.inputToAccountNoTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(miniStatement.getErrorMessageOfAccountNo(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_04_Account_No_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have space character");
		miniStatement.inputToAccountNoTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(miniStatement.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@Test
	public void TC_05_Account_No_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to account no textbox with first character as blank");
		miniStatement.inputToAccountNoTextbox(" ");
		
		log.info("Step-02: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(miniStatement.getErrorMessageOfAccountNo(), "Account Number must not be blank");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




