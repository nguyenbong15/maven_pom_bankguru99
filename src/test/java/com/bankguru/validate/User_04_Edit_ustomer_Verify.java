package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserEditCustomerPagePO;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewCustomerPagePO;

public class User_04_Edit_ustomer_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserNewCustomerPagePO newCustomer;
    UserEditCustomerPagePO editCustomer;
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
	public void TC_02_Verify_Customer_Id_With_Empty_Data() {
		log.info("Step-01: open edit customer");
		editCustomer=managerPage.openEditCustomerPage(driver);
		
		log.info("Step-02: input to customer id with empty data");
		editCustomer.inputToCustomerID("");
		
		log.info("Step-03: press tab key");
		editCustomer.pressTabKey();
		
		log.info("Step-04: verify error meassage 'Customer ID is required' displayed");
		verifyEquals(editCustomer.getErrorMessageOfCustomerID(), "Customer ID is required");
	}
	@Test
	public void TC_03_Verify_Customer_Id_Have_chracter() {
	
		log.info("Step-01: input to customer id have character data");
		editCustomer.inputToCustomerID("12d");
		
		log.info("Step-02: verify error meassage 'Characters are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfCustomerID(), "Characters are not allowed");
	}
	
	@Test
	public void TC_04_Verify_Customer_Id_With_Have_Special_chracter() {
		log.info("Step-01: input to customer id with have special chracter");
		editCustomer.inputToCustomerID("12!");
		
		log.info("Step-02: verify error meassage 'Special characters are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfCustomerID(), "Special characters are not allowed");
	}
	@Test
	public void TC_05_Verify_Customer_Id_With_Valid_Value() {
		
		log.info("Step-01: input to customer id with valid data");
		editCustomer.inputToCustomerID(customerid);
		
		log.info("Step-02: click to submit button");
		editCustomer.clickToSubmitbutton();
	}
	@Test
	public void TC_06_Address_With_Empty_Data() {
		
		log.info("Step-01: input to Address textbox with empty data");
		editCustomer.inputToAddressTextbox("");
		
		log.info("Step-02: press key tab");
		editCustomer.pressTabKeyOfAddress();
		
		log.info("Step-03: verify error message 'Address Field must not be blank");
		verifyEquals(editCustomer.getErrorMessageOfAddress(), "Address Field must not be blank");
	}
	@Test
	public void TC_07_City_With_Empty_Data() {
		
		log.info("Step-01: input to city textbox with empty data");
		editCustomer.inputToCityTextbox("");
		
		log.info("Step-02: press key tab");
		editCustomer.pressTabKeyofCity();
		
		log.info("Step-03: verify error message 'City Field must not be blank' displayed");
		verifyEquals(editCustomer.getErrorMessageOfCity(), "City Field must not be blank");
	}
	
	@Test
	public void TC_08_City_With_Special_Characeter() {
		
		log.info("Step-01: input to city textbox special character");
		editCustomer.inputToCityTextbox("12!QuangTrung");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfCity(), "Special characters are not allowed");
	}
	@Test
	public void TC_09_City_With_Have_Number_Characeter() {
		
		log.info("Step-01: input to city textbox with have number character");
		editCustomer.inputToCityTextbox("12VietNam");
		
		log.info("Step-02: verify error message 'Numbers are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfCity(), "Numbers are not allowed");
	}
	@Test
	public void TC_10_State_With_Empty_Data() {
		
		log.info("Step-01: input to state textbox with empty data");
		editCustomer.inputToStateTextBox("");
		
		log.info("Step-02: press key Tab ");
		editCustomer.pressKeyTabStateFiled();
		
		log.info("Step-03: verify error message 'State must not be blank' displayed ");
		verifyEquals(editCustomer.getErrorMessageOfState(), "State must not be blank");
	}
	@Test
	public void TC_11_State_With_Number_Data() {
		
		log.info("Step-01: input to state textbox with number data");
		editCustomer.inputToStateTextBox("12a");
		
		log.info("Step-03: verify error message 'Numbers are not allowed' displayed ");
		verifyEquals(editCustomer.getErrorMessageOfState(), "Numbers are not allowed");
	}
	@Test
	public void TC_12_State_With_Special_Character() {
		
		log.info("Step-01: input to state textbox with special character");
		editCustomer.inputToStateTextBox("!aa");
		
		log.info("Step-03: verify error message 'Special characters are not allowed' displayed ");
		verifyEquals(editCustomer.getErrorMessageOfState(), "Special characters are not allowed");
	}
	@Test
	public void TC_13_Pin_With_Empty_Data() {
		
		log.info("Step-01: input to pin texbox with empty data");
		editCustomer.inputToPinTextbox("");
		
		log.info("Step-02: press key tab");
		editCustomer.pressTabKeyOfAddress();
		
		log.info("Step-03: verify error message 'PIN Code must not be blank' displayed");
		verifyEquals(editCustomer.getErrorMessageOfPin(), "PIN Code must not be blank");
	}
	@Test
	public void TC_14_Pin_With_Have_Character() {
		
		log.info("Step-01: input to pin texbox with  number character data");
		editCustomer.inputToPinTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(editCustomer.getErrorMessageOfPin(), "Characters are not allowed");
	}
	@Test
	public void TC_15_Pin_Have_To_Six_Digital() {
		
		log.info("Step-01: input to pin texbox with  less 6 digital");
		editCustomer.inputToPinTextbox("123");
		
		log.info("Step-02: verify error message 'PIN Code must have 6 Digits' displayed");
		verifyEquals(editCustomer.getErrorMessageOfPin(), "PIN Code must have 6 Digits");

	}
	
	@Test
	public void TC_16_Pin_With_Special_Characeter() {
		
		log.info("Step-01: input to pin texbox with special character");
		editCustomer.inputToPinTextbox("12!");
	
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfPin(), "Special characters are not allowed");
	}
	@Test
	public void TC_17_Mobile_Number_With_Empty_Data() {
		
		log.info("Step-01: input to mobile phone textbox with empty data");
		editCustomer.inputToMobilePhoneTextbox("");
		
		log.info("Step-02: press key tab");
		editCustomer.pressTabKeyofCity();;
		
		log.info("Step-03: verify error message 'Mobile no must not be blank");
		verifyEquals(editCustomer.getErrorMessageOfMobilePhone(), "Mobile no must not be blank");
	}
	
	@Test
	public void TC_18_Mobile_Number_With_Have_Special_Character() {
		
		log.info("Step-01: input to mobile phone textbox with special character");
		editCustomer.inputToMobilePhoneTextbox("123!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(editCustomer.getErrorMessageOfMobilePhone(), "Special characters are not allowed");
	}
	@Test
	public void TC_19_Email_With_empty_Data() {
		
		log.info("Step-01: input to email textbox with empty data");
		editCustomer.inputToEmailTextbox("");
		
		log.info("Step-02: press key tab");
		editCustomer.pressKeyTabStateFiled();
		
		log.info("Step-03: verify error message 'Email-ID must not be blank");
		verifyEquals(editCustomer.getErrorMessageOfEmail(), "Email-ID must not be blank");
	}
	@Test
	public void TC_20_Email_With_Invail_Email() {
		
		log.info("Step-01: input to email textbox with have space");
		editCustomer.inputToEmailTextbox("hai");
		
		log.info("Step-02: verify error message 'Email-ID is not valid");
		verifyEquals(editCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-03: input to email textbox with have space");
		editCustomer.inputToEmailTextbox("hai@");
		
		log.info("Step-04: verify error message 'Email-ID is not valid");
		verifyEquals(editCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-05: input to email textbox with have space");
		editCustomer.inputToEmailTextbox("hai@gmail");
		
		log.info("Step-06: verify error message 'Email-ID is not valid");
		verifyEquals(editCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-07: input to email textbox with have space");
		editCustomer.inputToEmailTextbox("hai@gmail.");
		
		log.info("Step-08: verify error message 'Email-ID is not valid");
		verifyEquals(editCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-09: input to email textbox with have space");
		editCustomer.inputToEmailTextbox("hai@gmail.com");
		
		log.info("Step-10: verify error message not displayed");
		verifyFalse(editCustomer.isErrorMessagedisplayed());
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




