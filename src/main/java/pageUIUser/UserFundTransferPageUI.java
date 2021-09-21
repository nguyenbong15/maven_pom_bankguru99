package pageUIUser;

public class UserFundTransferPageUI {
	public static final String PAYER_ACCOUNT_TEXTBOX = "//input[@name='payersaccount']";
	public static final String PAYEES_ACCOUNT_TEXTBOX = "//input[@name='payeeaccount']";
	public static final String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static final String DESCRIPTION_TEXTBOX = "//input[@name='desc']";
	public static final String ERROR_MESSAGE_OF_PAYER_ACCOUNT_VERIFY = "//input[@name='payersaccount']/following-sibling::label";
	public static final String ERROR_MESSAGE_OF_PAYEES_ACCOUNT_VERIFY = "//input[@name='payeeaccount']/following-sibling::label";
	public static final String ERROR_MESSAGE_OF_AMOUNT_VERIFY = "//input[@name='ammount']/following-sibling::label";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String TEXT_CURRENT_AMOUNT = "//td[text()='Amount']/following-sibling::td";
	public static final String TEXT_TITEl_TABLE = "//p[@class='heading3']";

}
