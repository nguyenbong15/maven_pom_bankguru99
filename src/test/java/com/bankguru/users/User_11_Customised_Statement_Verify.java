package com.bankguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserCustomisedStatementPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_11_Customised_Statement_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserCustomisedStatementPagePO customisedStatement;
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
		customisedStatement=managerPage.openCustomisedStatmentPage(driver);
		
		log.info("Step-02: input to account no textbox with empty data");
		customisedStatement.inputToAccountNoTextbox("");
		
		log.info("Step-03: press key tab");
		customisedStatement.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfAccountNo(), "Account Number must not be blank");
	}
	@Test
	public void TC_02_Account_No_With_Have_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have character data");
		customisedStatement.inputToAccountNoTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	@Test
	public void TC_03_Account_No_With_Special_Character_Data() {
		
		log.info("Step-01: input to account no textbox with special character data");
		customisedStatement.inputToAccountNoTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfAccountNo(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_04_Account_No_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have space character");
		customisedStatement.inputToAccountNoTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@Test
	public void TC_05_Account_No_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to account no textbox with first character as blank");
		customisedStatement.inputToAccountNoTextbox(" ");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@Test
	public void TC_06_Minimum_Transaction_With_Empty_Data() {
		log.info("Step-02: input to minimum transaction textbox with empty data");
		customisedStatement.inputToMinimumTransactionTextbox("");
		
		log.info("Step-03: press key tab");
		customisedStatement.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfMinimumTransaction(), "Account Number must not be blank");
	}
	@Test
	public void TC_07_Minimum_Transaction_With_Have_Character_Data() {
		
		log.info("Step-01: input to minimum transaction textbox with have character data");
		customisedStatement.inputToMinimumTransactionTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfMinimumTransaction(), "Characters are not allowed");
	}
	@Test
	public void TC_08_Minimum_Transaction_With_Special_Character_Data() {
		
		log.info("Step-01: input to minimum transaction textbox with special character data");
		customisedStatement.inputToMinimumTransactionTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfMinimumTransaction(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_09_Minimum_Transaction_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to minimum transaction textbox with have space character");
		customisedStatement.inputToMinimumTransactionTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfMinimumTransaction(), "Characters are not allowed");
	}
	
	@Test
	public void TC_10_Minimum_Transaction_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to minimum transaction textbox with first character as blank");
		customisedStatement.inputToMinimumTransactionTextbox(" ");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfMinimumTransaction(), "Characters are not allowed");
	}
	
	
	@Test
	public void TC_11_Number_Transaction_With_Empty_Data() {
		log.info("Step-02: input to Number transaction textbox with empty data");
		customisedStatement.inputToNumberOfTransectionTextbox("");;
		
		log.info("Step-03: press key tab");
		customisedStatement.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfNumberOfTransection(), "Account Number must not be blank");
	}
	@Test
	public void TC_12_Number_Transaction_With_Have_Character_Data() {
		
		log.info("Step-01: input to Number transaction textbox with have character data");
		customisedStatement.inputToNumberOfTransectionTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfNumberOfTransection(), "Characters are not allowed");
	}
	@Test
	public void TC_13_Number_Transaction_With_Special_Character_Data() {
		
		log.info("Step-01: input to Number transaction textbox with special character data");
		customisedStatement.inputToNumberOfTransectionTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfNumberOfTransection(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_14_Number_Transaction_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to Number transaction textbox with have space character");
		customisedStatement.inputToNumberOfTransectionTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfNumberOfTransection(), "Characters are not allowed");
	}
	
	@Test
	public void TC_15_Number_Transaction_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to Number transaction textbox with first character as blank");
		customisedStatement.inputToNumberOfTransectionTextbox(" ");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(customisedStatement.getErrorMessageOfNumberOfTransection(), "Characters are not allowed");
	}
	
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




