package ____neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import ____neoStoxUtility.Utility;



public class NeoStoxDashBoardPage {
	
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
	
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	public NeoStoxDashBoardPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{   Thread.sleep(1000);
		if(popUpOkButton.isDisplayed())
		{
			Utility.ExplicitWait(driver, 8, popUpOkButton);	
			
			Utility.scrollIntoView(driver, popUpOkButton);
			
			Thread.sleep(2000);
			popUpOkButton.click();
			Reporter.log("clicking on PopUp ok button", true);
//			Utility.ExplicitWait(driver, 5, popUpCloseButton);
//			Utility.scrollIntoView(driver, popUpCloseButton);
//			popUpCloseButton.click();
//			Reporter.log("clicking on PopUp close button", true);
		}
		else
		{
			Reporter.log("There is no pop-up", true);
		}
	
	}
	
	
	public void logOutFromNeoStox(WebDriver driver) throws InterruptedException
	{
	 Utility.ExplicitWait(driver, 3, userName);
	userName.click();
	//Thread.sleep(1000);
	Utility.ExplicitWait(driver, 3, logOutButton);
	logOutButton.click();
	Reporter.log("Logging out from neoStox ", true);
	
	}
	
	public String getActualUserName()
	{
		String actualUserName = userName.getText();
		Reporter.log("getting actual user name",true);
		Reporter.log("Actual user name is-->"+actualUserName, true);
		return actualUserName;
	}
	
	public String getAcBalance()
	{	  String balance = acBalance.getText();
		  Reporter.log("getting AC Balance", true);
		  Reporter.log("Account balance is "+balance, true);
		  return balance;
	}

}
