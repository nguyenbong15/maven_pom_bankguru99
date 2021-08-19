package com.bankguru.users;

import org.testng.annotations.Test;

import commons.AbtractTest;

import org.testng.annotations.Parameters;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_New_Account_Verify extends AbtractTest {
	WebDriver driver;

	@Parameters(value = { "brower", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowerName(brower, url);
		
	}

	@Test
	public void f() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




