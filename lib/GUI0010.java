/*
TC Title : General  - Authenticated user - Logos and colors should be same as the omvco.com website
Date : 6/3/2015 3:21:42 PM
Author : Nguyen Dong
Design Step : 
*** TEST OBJECTIVE
Verify that a authenticated user can see the same logos and color as the omvco.com website.
*** HOW TO RUN THE TEST
1. Open web browser.
2. Access to http://qa-omv.sixsolutions.us
3. Input "admin01.auto@qa-omv.sixsolutions.us" into field "someone@example.com"
4. Input "R1;;winT" into field "Password"
5. Press button "Sign in"
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
public class GUI0010
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
	
	@Parameters ({"LoginURL","oUserName","oPassword","sUserName","sPassword","oLoginBtn","OMV_Logo"})
	@Test(alwaysRun = true)
	public void GUI0010(String LoginURL,String oUserName,String oPassword,String sUserName,String sPassword,String oLoginBtn,String OMV_Logo) throws Exception 
	{
		LoginURL = Utility.parseParameters(LoginURL);
		oUserName = Utility.parseParameters(oUserName);
		oPassword = Utility.parseParameters(oPassword);
		sUserName = Utility.parseParameters(sUserName);
		sPassword = Utility.parseParameters(sPassword);
		oLoginBtn = Utility.parseParameters(oLoginBtn);
		OMV_Logo = Utility.parseParameters(OMV_Logo);
		
		Selenium_Object.launchPage(LoginURL);
		Selenium_Object.login(oUserName,oPassword,sUserName,sPassword,oLoginBtn);
		Sikuli_Object.imageShouldBe(OMV_Logo);
	}
	
	@Parameters ({})
	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception 
	{
	}
}
