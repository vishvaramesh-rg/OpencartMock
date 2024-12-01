package testClass;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	HomePage hp;
	LoginPage lp;

	@Test(groups = {"regression"})
	public void verifyLoggedin() throws AWTException, IOException {
		hp=new HomePage(driver);
		lp=new LoginPage(driver);

		try {
			logger.info("***verifyLoggedin - started***");
			logger.debug("Application log started");
			hp.clickMyAccount();
			hp.clickLogin();
			Thread.sleep(1000);
			logger.info("Entered login page");
			lp.setEmail(p.getProperty("username"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			Thread.sleep(1000);
			boolean verifyLoggedIn = lp.verifyLoggedIn();
			Assert.assertEquals(verifyLoggedIn, true);
			lp.clickLogout();

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
