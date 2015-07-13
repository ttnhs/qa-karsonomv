/*
TC Title : Admin - Main Page - Branding Check
Date : 6/3/2015 3:21:42 PM
Author : Nguyen Dong
Design Step : 
*** TEST OBJECTIVE
Verify that the branding of OMV shown on top of the page should be correct and match with OVM branding standard.
*** HOW TO RUN THE TEST
1. Open web browser.
2. Access to http://qa-omv.sixsolutions.us
3. Input "admin01.auto@qa-omv.sixsolutions.us" into field "someone@example.com"
4. Input "R1;;winT" into field "Password"
5. Click button "Sign in"
6. Click link "Admins"
*** EXPECTED RESULTS:
Logos and colors should be same as the omvco.com website.

*/
package autoset.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import lib.com.utils.Log;
import lib.com.utils.Constants;
import lib.com.utils.Utility;
import lib.web.baseclass.WebDriverManager;
import lib.remote.pros.RemoteExecutor;
import lib.web.selenium.Selenium;
import lib.app.sikuli.Sikuli;
public class GUI0020
{
	//START OBJECT DECLARATION
	Log log;
	WebDriver xBrowser;
	Selenium Selenium_Object;
	Sikuli Sikuli_Object;
	//STOP OBJECT DECLARATION
	
	@Parameters ({"browser"})
	@BeforeClass(alwaysRun = true)
	protected void setUp(String browser) throws Exception 
	{
		log= Utility.createLog(this.getClass().getSimpleName());
		xBrowser= WebDriverManager.createWebDriver(browser, log);
		Selenium_Object= new Selenium(xBrowser, log);
		Sikuli_Object= new Sikuli(log);
		
	}
	
	@Parameters ({"LoginURL","oUserName","oPassword","sUserName","sPassword","oLoginBtn","oAdmins_Link","OMV_Logo"})
	@Test(alwaysRun = true)
	public void GUI0020(String LoginURL,String oUserName,String oPassword,String sUserName,String sPassword,String oLoginBtn,String oAdmins_Link,String OMV_Logo) throws Exception 
	{
		if (LoginURL.startsWith("$"))
		{LoginURL = Utility.getObjectRepository(LoginURL.substring(1));}
		if (oUserName.startsWith("$"))
		{oUserName = Utility.getObjectRepository(oUserName.substring(1));}
		if (oPassword.startsWith("$"))
		{oPassword = Utility.getObjectRepository(oPassword.substring(1));}
		if (sUserName.startsWith("$"))
		{sUserName = Utility.getObjectRepository(sUserName.substring(1));}
		if (sPassword.startsWith("$"))
		{sPassword = Utility.getObjectRepository(sPassword.substring(1));}
		if (oLoginBtn.startsWith("$"))
		{oLoginBtn = Utility.getObjectRepository(oLoginBtn.substring(1));}
		if (oAdmins_Link.startsWith("$"))
		{oAdmins_Link = Utility.getObjectRepository(oAdmins_Link.substring(1));}
		if (OMV_Logo.startsWith("$"))
		{OMV_Logo = Utility.getObjectRepository(OMV_Logo.substring(1));}
		
		Selenium_Object.launchPage(LoginURL);
		Selenium_Object.login(oUserName,oPassword,sUserName,sPassword,oLoginBtn);
		Selenium_Object.clickLink(oAdmins_Link);
		Sikuli_Object.imageShouldBe(OMV_Logo);
	}
	
	@Parameters ({})
	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception 
	{
	}
}
