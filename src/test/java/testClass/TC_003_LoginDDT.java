package testClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	HomePage hp;
	LoginPage lp;
	
	@Test(dataProvider = "data", dataProviderClass = DataProviders.class,groups = {"master"})
	public void verifyloginDDT(String username, String password, String res) throws AWTException, IOException {
		hp=new HomePage(driver);
		lp=new LoginPage(driver);

		try {
			logger.info("***verifyLoggedin - started***");
			logger.debug("Application log started");
			hp.clickMyAccount();
			hp.clickLogin();
			Thread.sleep(1000);
			logger.info("Entered login page");
			lp.setEmail(username);
			lp.setPassword(password);
			lp.clickLogin();
			Thread.sleep(1000);
			boolean v = lp.verifyLoggedIn();
			
			if(res.equalsIgnoreCase("valid")) {
				if(v==true) {
					lp.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					driver.navigate().refresh();
					logger.error("Valid cred but unable to login");
					Assert.assertTrue(false);
				}
			}
			if(res.equalsIgnoreCase("invalid")) {
				if(v==true) {
					lp.clickLogout();
					logger.error("Invalid cred, but able to login");
					Assert.assertTrue(false);
				}
				else {
					driver.navigate().refresh();
					Assert.assertTrue(true);
				}
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			screenshot();
			logger.error("Registered Unsuccessfull");
			logger.debug("logs closed");

			Assert.fail();
		}

		logger.debug("Application log ended");
		logger.info("***verifyLoggedin - ended***");
	}

}
