package testBase;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;


	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"browser","OS"})
	public void setup(String browser, String OS) throws IOException {

		//log4j2
		logger = LogManager.getLogger(this.getClass());

		//config.properties
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileReader file=new FileReader(path);
		p = new Properties();
		p.load(file);
		
		//selenium - grid
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			//os
			if(OS.equalsIgnoreCase("windows"))
				cap.setPlatform(Platform.WIN11);
			else if(OS.equalsIgnoreCase("mac"))
				cap.setPlatform(Platform.MAC);
			else
				System.out.println("No OS match");
			
			//browser
			switch (browser.toLowerCase()) {
			case "chrome": cap.setBrowserName(browser);break;
			case "edge": cap.setBrowserName(browser);break;
			default:
				System.out.println("No Browser match");
			}
			
			//driver
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			driver = HelperClass.BrowserLaunch(browser);
		}

		driver.manage().window().maximize();
		driver.get(p.getProperty("appurl"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@AfterClass(groups = {"sanity","regression","master"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}


	public String name() {
		String alpha = RandomStringUtils.randomAlphabetic(4);
		return alpha;
	}

	public String numbers() {
		String num = RandomStringUtils.randomNumeric(10);
		return num;
	}

	public String pass() {
		String num = RandomStringUtils.randomNumeric(4);
		String alpha = RandomStringUtils.randomAlphabetic(4);

		return (alpha+"@"+num);
	}

	public static BufferedImage screenshot() throws AWTException, IOException {
		Robot r= new Robot();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec = new Rectangle(dim);
		BufferedImage source = r.createScreenCapture(rec);
		File des = new File(System.getProperty("user.dir")+"\\screenshots\\errorscreen.png"+System.currentTimeMillis()+".png");
		ImageIO.write(source, "png", des);

		return source;


	}

	public static String captureScreen(String tname) {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		String tragetfilePath=System.getProperty("user.dir")+"\\screenshots\\Listenerscreenshot\\"+tname+"_"+ System.currentTimeMillis()+".png";
		File targetfile = new File(tragetfilePath);
		source.renameTo(targetfile);

		return tragetfilePath;

	}

}
