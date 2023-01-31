package ____neoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ____NeoStoxBase.base;
import ____neoStoxPOMClasses.NeoStoxDashBoardPage;
import ____neoStoxPOMClasses.NeoStoxHomePage;
import ____neoStoxPOMClasses.NeoStoxPasswordPage1;
import ____neoStoxPOMClasses.NeoStoxSignInPage;
import ____neoStoxUtility.Utility;


@Listeners(____neoStoxTestClasses.Listener.class)
public class ValidateNeoStoxUserName extends base {
 
	NeoStoxDashBoardPage dash;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage1 pass;
	String s="TCID-1111";
	
	@BeforeClass
	public void launchNeoStoxApp() throws IOException
	{
		launch_Browser();
		home = new NeoStoxHomePage(driver);
		signIn = new NeoStoxSignInPage(driver);
		pass = new NeoStoxPasswordPage1(driver);
		dash = new NeoStoxDashBoardPage(driver);
	}
	
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		home.clickOnSignInButton();
		Utility.implicitWait(1000, driver);
		
		signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobileNo"));
		signIn.clickOnSignInButton();
		
	    Utility.implicitWait(4000, driver);
		pass.enterPassword(Utility.readDataFromPropertyFile("password"));
		pass.clickOnSubmitButton(driver);
		
		Utility.implicitWait(1000, driver);
		dash.handlePopUp(driver);
	}
	
	@Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
	{ // Assert.fail();
		Assert.assertEquals(dash.getActualUserName(), Utility.readDataFromPropertyFile("username"),"actual and expected user name are not matching TC is failed");
	//Utility.takeScreenshot(driver, Utility.readDataFromPropertyFile("TestId"));
	}
	@Test
	public void validateACBalance()
	{ 
		Assert.assertNotNull(dash.getAcBalance(), "AC balance is null TC failed");
		//Assert.assertNull(dash.getAcBalance(), "AC balance is null TC failed");
	}
	
	@AfterMethod
	public void logOutFromNeoStox() throws InterruptedException
	{
		dash.logOutFromNeoStox(driver);
		
	}
	
	@AfterClass
	public void closeNeoStoxApp() throws InterruptedException
	{
		driver.close();
		Reporter.log("closing Application ", true);
		//Thread.sleep(1000);
	}
}
