package pageObjectUser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIUser.UserDeleteCustomerPageUI;

public class UserDeleteCustomerPagePO extends AbtractPage{
	WebDriver driver;

	public UserDeleteCustomerPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerID(String customerid) {
		waitToElementVisible(driver, UserDeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserDeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerid);
		
	}

	public String getErrorMessageOfCustomerID() {
		waitToElementVisible(driver, UserDeleteCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
		return getTextElement(driver, UserDeleteCustomerPageUI.ERROR_MESSAGE_OF_CUSTOMER_ID_VERIFY);
	
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, UserDeleteCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver,  UserDeleteCustomerPageUI.SUBMIT_BUTTON);
	}
	public void pressTabKey() {
		waitToElementVisible(driver, UserDeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, UserDeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX,Keys.TAB);
		sleepMiliSecond(500);
	}

	
}
