package com.bankguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserChangePasswordPagePO;
import pageObjectUser.UserFundTransferPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_10_Fund_Transfer_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserFundTransferPagePO funTransfer;
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
	public void TC_01_Payer_Account_No_With_Empty_Data() {
		log.info("Step-01: open change password  page");
		funTransfer=managerPage.openFundTransferPage(driver);
		
		log.info("Step-02: input to payer account textbox with empty data");
		funTransfer.inputToPayerAccountTextbox("");
		
		log.info("Step-03: press key tab");
		funTransfer.pressTabKey();
		
		log.info("Step-04: verify error message 'Payers Account Number must not be blank' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayerAccount(), "Payers Account Number must not be blank");
	}
	@Test
	public void TC_02_Payer_Account_No_With_Have_Character() {
		log.info("Step-01: input to payer account textbox with have character");
		funTransfer.inputToPayerAccountTextbox("1df");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayerAccount(), "Characters are not allowed");
	}
	@Test
	public void TC_03_Payer_Account_No_With_Have_Special_Character() {
		log.info("Step-01: input to payer account textbox with have character");
		funTransfer.inputToPayerAccountTextbox("1!2");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayerAccount(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_04_Payees_Account_No_With_Empty_Data() {
		
		log.info("Step-01: input to payees account textbox with empty data");
		funTransfer.inputToPayeesAccountTextbox("");
		
		log.info("Step-02: press key tab");
		funTransfer.pressTabKey();
		
		log.info("Step-03: verify error message 'Payees Account Number must not be blank' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayeesAccount(), "Payees Account Number must not be blank");
	}
	@Test
	public void TC_05_Payees_Account_No_With_Have_Character() {
		log.info("Step-01: input to payees account textbox with have character");
		funTransfer.inputToPayeesAccountTextbox("1df");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayeesAccount(), "Characters are not allowed");
	}
	@Test
	public void TC_06_Payees_Account_No_With_Have_Special_Character() {
		log.info("Step-01: input to payees account textbox with have character");
		funTransfer.inputToPayeesAccountTextbox("1!2");
		
		log.info("Step-02: verify error message ' Special characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfPayeesAccount(), "Special characters are not allowed");
	}
	@Test
	public void TC_07_Amount_With_Empty_Data() {
		
		log.info("Step-01: input to Amount  textbox with empty data");
		funTransfer.inputToAmountTextbox("");
		
		log.info("Step-02: press key tab");
		funTransfer.pressTabKey();
		
		log.info("Step-03: verify error message 'Amount field must not be blank' displayed");
		verifyEquals(funTransfer.getErrorMessageOfAmount(), "Amount field must not be blank");
	}
	@Test
	public void TC_08_Amount_With_Have_Character() {
		log.info("Step-01: input to Amount textbox with have character");
		funTransfer.inputToAmountTextbox("1df");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfAmount(), "Characters are not allowed");
	}
	@Test
	public void TC_09_Amount_With_Have_Special_Character() {
		log.info("Step-01: input to Amount textbox with have character");
		funTransfer.inputToAmountTextbox("1!2");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(funTransfer.getErrorMessageOfAmount(), "Special characters are not allowed");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




