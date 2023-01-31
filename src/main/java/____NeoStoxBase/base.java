package ____NeoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import ____neoStoxUtility.Utility;



public class base {

	protected static WebDriver driver;
	public void launch_Browser() throws IOException
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Selinium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://neostox.com/");
		driver.get(Utility.readDataFromPropertyFile("url"));
		Utility.implicitWait(1000, driver);
		Reporter.log("launching browser", true);
		
	}

}
