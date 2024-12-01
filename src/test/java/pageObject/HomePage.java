package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//a[@title='My Account']") WebElement a_myaccount_loc;
	@FindBy (xpath ="//a[normalize-space()='Register']") WebElement a_register_loc;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement a_login_loc;
	
	
	//actions
	public void clickMyAccount() {
		a_myaccount_loc.click();
	}
	
	public void clickRegister() {
		a_register_loc.click();
	}
	
	public void clickLogin() {
		a_login_loc.click();
	}
	
	

}
