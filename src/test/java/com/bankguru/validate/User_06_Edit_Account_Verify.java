package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserEditAccountPagePO;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewAccountPagePO;

public class User_06_Edit_Account_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserNewAccountPagePO newAccount;
    UserEditAccountPagePO editAccount;
    UserManagerPagePO managerPage;
	 String intialDeposit,customerid,accountid;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage=PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage=loginPage.loginToSystem("mngr348463","nUsajEh");
	    customerid="23874";
	    intialDeposit="123456";
	    accountid="96218";
	}	
	//@Test
	public void TC_01_Create_New_Account() {
		log.info("Step-01: open new customer page");
		newAccount=managerPage.openNewAccountPage(driver);
		
		log.info("Step-02: input to customer id texbox");
		newAccount.inputToCustomerIdTextbox(customerid);;
		
		log.info("Step-03: select item 'Current' in Account type dropdown");
		newAccount.selecItemInAccountTypeDropDown("Current");
		
		log.info("Step-04: input to Initial deposit textbox ");
		newAccount.inputToInitialDepositTextbox(intialDeposit);
		
		log.info("Step-05: click to submit button ");
		newAccount.clickToSubmitButton();
		
		log.info("Step-06: get text Account id");
		//accountid = newAccount.getTextAccountID();
	}
	
	@Test
	public void TC_01_Account_No_With_Empty_Data() {
		log.info("Step-01: open edit account page");
		editAccount=newAccount.openEditAccountPage(driver);
		
		log.info("Step-02: input to account no textbox with empty data");
		editAccount.inputToAccountNoTextbox("");
		
		log.info("Step-03: press key tab");
		editAccount.pressTabKey();
		
		log.info("Step-04: verify error message 'Account Number must not be blank' displayed");
		verifyEquals(editAccount.getErrorMessageOfAccountNo(), "Account Number must not be blank");
	}
	@Test
	public void TC_02_Account_No_With_Have_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have character data");
		editAccount.inputToAccountNoTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	@Test
	public void TC_04_Account_No_With_Special_Character_Data() {
		
		log.info("Step-01: input to account no textbox with special character data");
		editAccount.inputToAccountNoTextbox("12!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfAccountNo(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_05_Account_No_With_Have_Space_Character_Data() {
		
		log.info("Step-01: input to account no textbox with have space character");
		editAccount.inputToAccountNoTextbox("12 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	@Test
	public void TC_06_Account_No_With_Frist_Character_As_Blank() {
		
		log.info("Step-01: input to account no textbox with first character as blank");
		editAccount.inputToAccountNoTextbox(" 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfAccountNo(), "Characters are not allowed");
	}
	
	
	@Test
	public void TC_05_Account_No_With_Valid_Value() {
		
		log.info("Step-01: input to account no textbox with valid value");
		editAccount.inputToAccountNoTextbox(accountid);
		
		log.info("Step-02: click to submit button");
		editAccount.clickToSubmitButton();
		
	}
	@Test
	public void TC_06_Customer_Id_With_Empty_Data() {
		
		log.info("Step-01: input to customer id with empty data");
		editAccount.inputToCustomerID("");;
		
		log.info("Step-02: press key tab");
		editAccount.pressTabKey();
		
		log.info("Step-03: verify error message 'Customer ID is required' displayed");
		verifyEquals(editAccount.getErrorMessageOfCustomerID(), "Customer ID is required");
	}
	@Test
	public void TC_07_Customer_Id_With_Character_Data() {
		
		log.info("Step-01: input to customer id with character data");
		editAccount.inputToCustomerID("1234da");

		log.info("Step-02: verify error message'Characters are not allowed'displayed");
		verifyEquals(editAccount.getErrorMessageOfCustomerID(), "Characters are not allowed");
	}
	@Test
	public void TC_08_Customer_Id_With_Special_Character_Data() {
		
		log.info("Step-01: input to customer id with special character data");
		editAccount.inputToCustomerID("13212c!");
		
		log.info("Step-03: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfCustomerID(), "Special characters are not allowed");
	}
	@Test
	public void TC_09_Customer_Id_With_Have_Blank_Space_Data() {
		
		log.info("Step-01: input to customer id with have blank space data");
		editAccount.inputToCustomerID("132 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfCustomerID(), "Characters are not allowed");
	}
	@Test
	public void TC_10_Customer_Id_With_First_Character_Is_Space_Data() {
		
		log.info("Step-01: input to Initial deposit with first character space data");
		editAccount.inputToCustomerID(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(editAccount.getErrorMessageOfCustomerID(), "First character can not have space");
	}
	@Test
	public void TC_11_Balance_With_Empty_Data() {
		
		log.info("Step-01: input to Balance with empty data");
		editAccount.inputToBalanceTextbox("");;
		
		log.info("Step-02: press key tab");
		editAccount.pressTabKey();
		
		log.info("Step-03: verify error message 'Customer ID is required' displayed");
		verifyEquals(editAccount.getErrorMessageOfBalance(), "Customer ID is required");
	}
	@Test
	public void TC_12_Balance_With_Character_Data() {
		
		log.info("Step-01: input to Balance with character data");
		editAccount.inputToBalanceTextbox("1234da");

		log.info("Step-02: verify error message'Characters are not allowed'displayed");
		verifyEquals(editAccount.getErrorMessageOfBalance(), "Characters are not allowed");
	}
	@Test
	public void TC_13_Balance_With_Special_Character_Data() {
		
		log.info("Step-01: input to Balance with special character data");
		editAccount.inputToBalanceTextbox("13212c!");
		
		log.info("Step-03: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfBalance(), "Special characters are not allowed");
	}
	@Test
	public void TC_14_Balance_With_Have_Blank_Space_Data() {
		
		log.info("Step-01: input to Balance with have blank space data");
		editAccount.inputToBalanceTextbox("132 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editAccount.getErrorMessageOfBalance(), "Characters are not allowed");
	}
	@Test
	public void TC_15_Balance_With_First_Character_Is_Space_Data() {
		
		log.info("Step-01: input to Balance with first character space data");
		editAccount.inputToBalanceTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(editAccount.getErrorMessageOfBalance(), "First character can not have space");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




