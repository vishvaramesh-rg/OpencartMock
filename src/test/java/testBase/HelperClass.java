package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	static WebDriver driver;
	
	public static  WebDriver BrowserLaunch(String browser) {
		
		
		switch (browser.toLowerCase()){
		case "chrome": WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();break;
		case "edge": WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();break;		
			
			
		default:
			System.out.println("No match");
		}
		return driver;
		
		
	}

}
