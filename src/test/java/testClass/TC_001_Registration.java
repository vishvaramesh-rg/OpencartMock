package testClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass {
	
	HomePage hp;
	RegistrationPage rp;
	
	@Test(groups = {"sanity"})
	public void verifyregistration() throws AWTException, IOException {
		hp=new HomePage(driver);
		rp=new RegistrationPage(driver);
		
		
		try {
			logger.info("***verifyregistration - started***");
			logger.debug("Application log started");
			
			hp.clickMyAccount();
			hp.clickRegister();
			Thread.sleep(1000);
			logger.info("Entered register page");
			rp.setFirstname(name());
			rp.setLastname(name());
			rp.setEmail(name()+"@gm.com");
			rp.setPhnumber(numbers());
			String passWord = pass();
			rp.setpassword(passWord);
			rp.setconfirmPassword(passWord);
			rp.clickterms();
			rp.clickSubmit();
			Thread.sleep(2000);
			boolean registerVerification = rp.RegisterVerification();
			Assert.assertEquals(registerVerification, true);
			logger.info("Registered successfull");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			screenshot();
			logger.error("Registered Unsuccessfull");
			logger.debug("logs closed");
			
			Assert.fail();
		}
		logger.debug("Application log ended");
		logger.info("***verifyregistration - ended***");
		
		
	}

}
