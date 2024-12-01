package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement inp_fname_loc;
	@FindBy(xpath="//input[@id='input-lastname']")   WebElement inp_lname_loc;
	@FindBy(xpath="//input[@id='input-email']")  WebElement inp_email_loc;
	@FindBy(xpath="//input[@id='input-telephone']")  WebElement inp_tphone_loc;
	
	@FindBy(xpath="//input[@id='input-password']")   WebElement inp_password_loc;
	@FindBy(xpath="//input[@id='input-confirm']")   WebElement inp_cpassword_loc;
	@FindBy(xpath="//input[@name='agree']")   WebElement chx_privacy_loc;
	@FindBy(xpath="//input[@value='Continue']")   WebElement btn_continue_loc;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement h1_confirmtext_loc;
	
	//actions
	
	public void setFirstname(String firstName) {
		inp_fname_loc.sendKeys(firstName);
	}
	
	public void setLastname(String lastName) {
		inp_lname_loc.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		inp_email_loc.sendKeys(email);
	}
	
	public void setPhnumber(String phnumber) {
		inp_tphone_loc.sendKeys(phnumber);
	}
	
	public void setpassword(String password) {
		inp_password_loc.sendKeys(password);
	}
	
	public void setconfirmPassword(String Cpassoword) {
		inp_cpassword_loc.sendKeys(Cpassoword);
	}
	
	public void clickterms() {
		chx_privacy_loc.click();
	}
	
	public void clickSubmit() {
		btn_continue_loc.click();
	}
	
	public boolean RegisterVerification() {
		boolean displayed = h1_confirmtext_loc.isDisplayed();
		return displayed;
	}
	
}
