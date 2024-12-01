package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-email']")   WebElement inp_email_loc;
	@FindBy(xpath="//input[@id='input-password']")   WebElement inp_password_loc;
	@FindBy(xpath="//input[@value='Login']")   WebElement btn_login_loc;
	@FindBy(xpath="//h2[normalize-space()='My Account']")  WebElement h2_myaccount_loc;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  WebElement btn_logout_loc;

	
	//actions
	public void setEmail(String email) {
		inp_email_loc.sendKeys(email);
	}
	
	public void setPassword(String password) {
		inp_password_loc.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login_loc.click();
	}
	
	public boolean verifyLoggedIn() {
		boolean displayed = h2_myaccount_loc.isDisplayed();
		return displayed;
	}
	
	public void clickLogout() {
		btn_logout_loc.click();
	}

}
