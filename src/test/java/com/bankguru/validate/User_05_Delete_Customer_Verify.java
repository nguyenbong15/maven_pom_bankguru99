package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserDeleteCustomerPagePO;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewCustomerPagePO;

public class User_05_Delete_Customer_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserNewCustomerPagePO newCustomer;
    UserDeleteCustomerPagePO deleteCustomer;
    UserManagerPagePO managerPage;
	 String dateOfBirth,customername,address,city,state,pin,phoneNumber,password,email,customerid;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage=PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage=loginPage.loginToSystem("mngr348463","nUsajEh");
	    customername="John";
	    dateOfBirth="01/01/2000";
	    address="12HoangTrung";
	    city="New York";
	    state="England";
	    pin="123456";
	    phoneNumber="09876543";
	    email="john"+getRandomNumber()+"@gmail.com";
	    password="123456";
	    customerid="23874";
	}	
	//@Test
	public void TC_01_Create_New_Customer() {
		log.info("Step-01: open new customer page");
		newCustomer=managerPage.openNewCustomerPage(driver);
		
		log.info("Step-02: input to customer texbox");
		newCustomer.inputToCustomerName(customername);
		
		log.info("Step-03: click to male radio");
		newCustomer.clickToGenderMaleRadio();
		
		log.info("Step-04: input to date of birth ");
		newCustomer.inputToDateOfBirth(dateOfBirth);
		
		log.info("Step-05: input to address textbox ");
		newCustomer.inputToAddressTextbox(address);
		
		log.info("Step-06: input to city textbox ");
		newCustomer.inputToCityTextbox(city);
		
		log.info("Step-07: input to state textbox ");
		newCustomer.inputToStateTextBox(state);
		
		log.info("Step-08: input to pin textbox ");
		newCustomer.inputToPinTextbox(pin);
		
		log.info("Step-09: input to mobile number textbox ");
		newCustomer.inputToMobilePhoneTextbox(phoneNumber);
		
		log.info("Step-10: input to email textbox ");
		newCustomer.inputToEmailTextbox(email);
		
		log.info("Step-11: input to password textbox ");
		newCustomer.inputToPasswordTextbox(password);
		
		log.info("Step-12: click to submit button ");
		newCustomer.clickToSubmitbutton();
		
		log.info("Step-13: get customer id ");
		customerid=newCustomer.getCustomerId();
		
	}
	
	@Test
	public void TC_02_Customer_Id_With_Empty_Data() {
		log.info("Step-01: open new customer page");
		deleteCustomer=managerPage.openDeleteCustomerPage(driver);
		
		log.info("Step-02: input to Customer id with empty data");
		deleteCustomer.inputToCustomerID("");
		
		log.info("Step-03: press key tab");
		deleteCustomer.pressTabKey();
		
		log.info("Step-04: verify error message 'Customer ID is required' displayed");
		verifyEquals(deleteCustomer.getErrorMessageOfCustomerID(), "Customer ID is required");
	}
	@Test
	public void TC_03_Customer_ID_With_Have_Character_Data() {
		
		log.info("Step-01: input to Customer id with have character data");
		deleteCustomer.inputToCustomerID("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(deleteCustomer.getErrorMessageOfCustomerID(), "Characters are not allowed");
	}
	@Test
	public void TC_04_Customer_ID_With_Special_Character_Data() {
		
		log.info("Step-01: input to Customer id with special character data");
		deleteCustomer.inputToCustomerID("name!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(deleteCustomer.getErrorMessageOfCustomerID(), "Special characters are not allowed");
	}
	@Test
	public void TC_05_Customer_Id_With_First_Space_Character_Data() {
		
		log.info("Step-01: input to Customer id with First space character data");
		deleteCustomer.inputToCustomerID(" ");
		
		log.info("Step-02: verify error message 'First character can not have space' displayed");
		verifyEquals(deleteCustomer.getErrorMessageOfCustomerID(), "First character can not have space");
	}
	@Test
	public void TC_06_Customer_ID_With_Have_blank_Space() {
	
		log.info("Step-01: input to Customer id with have blank space ");
		deleteCustomer.inputToCustomerID(" ");
	
		log.info("Step-02: verify error message 'First character can not have space' displayed");
		verifyEquals(deleteCustomer.getErrorMessageOfCustomerID(), "First character can not have space");
	}
	//@Test
	public void TC_07_Verify_Customer_Id_With_Valid_Value() {
		
		log.info("Step-01: input to customer id with valid data");
		deleteCustomer.inputToCustomerID(customerid);
		
		log.info("Step-02: click to submit button");
		deleteCustomer.clickToSubmitButton();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




