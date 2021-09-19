package com.bankguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserDepositPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_13_Payment_02_Transfer_Money extends AbtractTest {
	WebDriver driver;
	CommonLoginPagePO loginPage;
	UserManagerPagePO managerPage;
	UserDepositPagePO depositpage;
	String customerid, accountId, initialDeposit;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage = PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage = loginPage.loginToSystem("mngr354393", "ubynuqy");

//	    customerid=User_12_Payment_01_Create_And_Edit_Customer_And_Account.customerid;
//	    accountId=User_12_Payment_01_Create_And_Edit_Customer_And_Account.accountId;
//	    initialDeposit=User_12_Payment_01_Create_And_Edit_Customer_And_Account.initialDeposit;
		customerid = "66921";
		accountId = "97919";
		initialDeposit = "13000";
	}

	@Test
	public void TC_01_Tranfer_Money_Into_A_Current_Account() {
		log.info("Step-01: open deposit page");
		depositpage=managerPage.openDepositPage(driver);

		log.info("Step-02: input to account no textbox with text '97919'");
		depositpage.inputToAccountNoTextbox(accountId);

		log.info("Step-03: input to amount textbox with text '7000'");
		depositpage.inputToAmountTextbox("7000");

		log.info("Step-04: input to description textbox with text 'deposit'");
		depositpage.inputToDescriptionTextbox("deposit");

		log.info("Step-05: click to submit button");
		depositpage.clickToSubmitButton();

		log.info("Step-06: verify message sucessfuly displayed");
		verifyEquals(depositpage.getTextTitlePage(), "Transaction details of Deposit for Account 97919");

		log.info("Step-07: verify current amount equal 20000");
		verifyEquals(depositpage.getTextCurrentAmount(), "20000");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
