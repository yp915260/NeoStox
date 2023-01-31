package ____neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import ____neoStoxUtility.Utility;



public class NeoStoxPasswordPage1 {
	
	@FindBy(id = "txt_accesspin") private WebElement passwordField;
	@FindBy(id = "lnk_submitaccesspin") private WebElement submitButton;
	public NeoStoxPasswordPage1(WebDriver driver)
	{
	PageFactory.initElements(driver,this );
	}
	public void enterPassword(String password)
	{
	passwordField.sendKeys(password);
	Reporter.log("entering password", true);
	}
	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException
	{
	//Thread.sleep(500);
	Utility.ExplicitWait(driver, 5, submitButton);
	Thread.sleep(200);
	submitButton.click();
	Reporter.log("clicking on submit button", true);
	}

}
