package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserBalancePagePO;
import pageObjectUser.UserDepositPagePO;
import pageObjectUser.UserFundTransferPagePO;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewAccountPagePO;
import pageObjectUser.UserWithdrawPagePO;

public class User_02_Payment_02_Transfer_Money extends AbtractTest {
	WebDriver driver;
	CommonLoginPagePO loginPage;
	UserManagerPagePO managerPage;
	UserDepositPagePO depositpage;
	UserWithdrawPagePO withdrawpage;
	UserNewAccountPagePO newAccount;
	UserFundTransferPagePO fundtransferpage;
	UserBalancePagePO balancepage;
	String customerid, accountId, initialDeposit, depositmoney, 
	withdrawMoney, transfermoney ;
	public static String  accountPayees;
    int caclulate=0;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage = PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage = loginPage.loginToSystem("mngr354393", "ubynuqy");

	    customerid=User_01_Payment_01_Create_And_Edit_Customer_And_Account.customerid;
	    accountId=User_01_Payment_01_Create_And_Edit_Customer_And_Account.accountId;
	    initialDeposit=User_01_Payment_01_Create_And_Edit_Customer_And_Account.initialDeposit;
//		customerid = "66921";
//		accountId = "97919";
//		accountPayees = "98008";
//		initialDeposit = "13000";
	    depositmoney="50000";
	    withdrawMoney="20000";
	    transfermoney="10000";
	    		
	}

	@Test
	public void TC_01_Deposit_Money_Into_A_Current_Account() {
		log.info("Step-01: open deposit page");
		depositpage = managerPage.openDepositPage(driver);

		log.info("Step-02: input to account no textbox with text '97919'");
		depositpage.inputToAccountNoTextbox(accountId);

		log.info("Step-03: input to amount textbox with text '7000'");
		depositpage.inputToAmountTextbox(depositmoney);

		log.info("Step-04: input to description textbox with text 'deposit'");
		depositpage.inputToDescriptionTextbox("deposit");

		log.info("Step-05: click to submit button");
		depositpage.clickToSubmitButton();

		log.info("Step-06: verify message sucessfuly displayed");
		verifyEquals(depositpage.getTextTitlePage(), "Transaction details of Deposit for Account " +accountId);

		log.info("Step-07: verify current amount equal 250000");
		caclulate=Integer.parseInt(initialDeposit)+Integer.parseInt(depositmoney);
		verifyEquals(depositpage.getTextCurrentAmount(),String.valueOf(caclulate));

	}

	@Test
	public void TC_02_Withdraw_Money_From_A_Current_Account() {
		//depositpage = managerPage.openDepositPage(driver);
		log.info("Step-01: open deposit page");
		withdrawpage = depositpage.openWithdrawPage(driver);

		log.info("Step-02: input to account no textbox with text '97919'");
		withdrawpage.inputToAccountNoTextbox(accountId);

		log.info("Step-03: input to amount textbox with text '7000'");
		withdrawpage.inputToAmountTextbox(withdrawMoney);

		log.info("Step-04: input to description textbox with text 'withdraw 3000 money'");
		withdrawpage.inputToDescriptionTextbox("withdraw 3000 money");

		log.info("Step-05: click to submit button");
		withdrawpage.clickToSubmitButton();

		log.info("Step-06: verify message sucessfuly displayed");
		verifyEquals(withdrawpage.getTextTitlePage(), "Transaction details of Withdrawal for Account "+accountId);

		log.info("Step-07: verify current amount equal 200000");
		caclulate=Integer.parseInt(initialDeposit)+Integer.parseInt(depositmoney)-Integer.parseInt(withdrawMoney);
		verifyEquals(withdrawpage.getTextCurrentAmount(),String.valueOf(caclulate));

	}

	@Test
	public void TC_03_Transfer_Money_Into_A_Other_Account() {

		log.info("Step-01: open new account page");
		newAccount = withdrawpage.openNewAccountPage(driver);

		log.info("Step-02: input to Customer id texbox");
		newAccount.inputToCustomerIdTextbox(customerid);

//		log.info("Step-03: select item in Account type dropdown");
//		newAccount.selecItemInAccountTypeDropDown("Savings");

		log.info("Step-04: input to Initial deposit text box");
		newAccount.inputToInitialDepositTextbox("1000");

		log.info("Step-05: click to submit button");
		newAccount.clickToSubmitButton();

		log.info("Step-06: verify message success 'Account Generated Successfully!!!' displayed");
		verifyEquals(newAccount.getMessageSuccess(), "Account Generated Successfully!!!");

		log.info("Step-07: verify text  Current Amount equal initial Deposit");
		verifyEquals(newAccount.getAmountDeposit(), "1000");

		log.info("Step-08: get text account id");
		accountPayees = newAccount.getTextAccountID();
//		  System.out.println(accountId);

		log.info("Step-09: open fund transfer page");
		fundtransferpage = withdrawpage.openFundTransferPage(driver);

		log.info("Step-10: input to payer account no textbox ");
		fundtransferpage.inputToPayerAccountTextbox(accountId);

		log.info("Step-11: input to payee  account no textbox ");
		fundtransferpage.inputToPayeesAccountTextbox(accountPayees);

		log.info("Step-12: input to description textbox with text 'withdraw 3000 money'");
		fundtransferpage.inputToAmountTextbox(transfermoney);
		
		log.info("Step-12: input to description textbox with text 'withdraw 3000 money'");
		fundtransferpage.inputToDescriptionTextbox("chuyen tien");
		

		log.info("Step-13: click to submit button");
		fundtransferpage.clickToSubmitButton();

		log.info("Step-14: verify message sucessfuly displayed");
		verifyEquals(fundtransferpage.getTextTitlePage(), "Fund Transfer Details");

		log.info("Step-15: verify  amount  equal 50000");
		verifyEquals(fundtransferpage.getTextAmount(), transfermoney);

	}
	@Test
	public void TC_04_Check_Amount_Of_Current_Acounnt() {
		log.info("Step-01: open Balance Enquiry page");
		balancepage=fundtransferpage.openBalanceEnquiry(driver);//Balance Enquiry
		
		log.info("Step-02: input to account no textbox");
		balancepage.inputToAccountNoTextbox(accountId);
		
		log.info("Step-03: click to submit button");
		balancepage.clickToSubmitButton();
		
		log.info("Step-04: get title table and verify ");
		verifyEquals(balancepage.getTextTitlePage(), "Balance Details for Account "+accountId);
		
		log.info("Step-05: get title table and verify amount of curren account ");
		caclulate=Integer.parseInt(initialDeposit)+Integer.parseInt(depositmoney)-Integer.parseInt(withdrawMoney)-Integer.parseInt(transfermoney);
		verifyEquals(balancepage.getTextCurrentAmount(), String.valueOf(caclulate));
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
