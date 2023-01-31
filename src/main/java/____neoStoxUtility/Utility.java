package ____neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utility {

	//excel
	//wait
	//screenShot
	//scrollIntoView
	//read data from property file
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//1.create an object of properties file
		Properties prop=new Properties();
		//2.create object of fileInputStream
		FileInputStream myfile= new FileInputStream("C:\\Users\\Pooja\\eclipse-workspace\\20_Aug_Even_MVN\\NeoStoxproperties.properties");
		//3.load file
		prop.load(myfile);
		//4.read data from property file
		String value = prop.getProperty(key);
		Reporter.log("Reading data from NeoStoxProperties.properties file", true);
		Reporter.log("data is "+value, true);
		
		return value;
	}
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myfile = new File("C:\\\\Users\\\\banso\\\\Desktop\\\\software testing\\\\excelsheet selenium practice\\\\seleniumpractice.xlsx");
		 Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
		 String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		 Reporter.log("Reading data from excel row is "+row+"cell is "+cell, true);
		 Reporter.log("data is "+value, true);
		 return value;
	}
	
	public static void implicitWait(int time ,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("waiting for "+time+"ms", true);
	}
	
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Pooja\\Desktop\\Software testing\\Testing Screenshot\\testing"+fileName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot ", true);
		Reporter.log("screenshot taken and saved at "+dest, true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling into view to"+element.getText(), true);
	}
	
	public static void ExplicitWait(WebDriver driver,int time,WebElement webelement)
	{
		WebDriverWait explicit=new WebDriverWait(driver, Duration.ofSeconds(time));
		
		explicit.until(ExpectedConditions.visibilityOf(webelement));
		
		Reporter.log("use explicit time wait for webelement "+webelement+"wait time is"+time, true);
	}


}
