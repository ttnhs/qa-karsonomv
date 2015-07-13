/*
TC Title : General  - HTTPS enforced - Redirected to HTTPS
Date : 6/3/2015 11:24:37 AM
Author : Nguyen Dong
Design Step : 
*** TEST OBJECTIVE
Verify that if a user try to access to login page via HTTP, it will be redirected to HTTPS login page.  After logged on, if a user try to access to a specific resource via HTTP, it will be redirected to HTTPS page.
*** HOW TO RUN THE TEST
1. Open web brower.
2. Access to the following pages via HTTP
	- Login:  http://qa-omv.sixsolutions.us
	- Manage Companies http://qa-omv.sixsolutions.us/Admin/Companies
*** EXPECTED RESULTS:
The access will be re-directed to HTTPS properly.

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
public class GUI0001
{
	//START OBJECT DECLARATION
	Log log;
	WebDriver xBrowser;
	Selenium Selenium_Object;
	//STOP OBJECT DECLARATION
	
	@Parameters ({"browser"})
	@BeforeClass(alwaysRun = true)
	protected void setUp(String browser) throws Exception 
	{
		log= Utility.createLog(this.getClass().getSimpleName());
		xBrowser= WebDriverManager.createWebDriver(browser, log);
		Selenium_Object= new Selenium(xBrowser, log);
		
	}
	
	@Parameters ({"LoginURL","sProtocol","oUserName","oPassword","sUserName","sPassword","oLoginBtn","wait","ManageCompanyURL"})
	@Test(alwaysRun = true)
	public void GUI0001(String LoginURL,String sProtocol,String oUserName,String oPassword,String sUserName,String sPassword,String oLoginBtn,String wait,String ManageCompanyURL) throws Exception 
	{
		LoginURL = Utility.parseParameters(LoginURL);
		sProtocol = Utility.parseParameters(sProtocol);
		oUserName = Utility.parseParameters(oUserName);
		oPassword = Utility.parseParameters(oPassword);
		sUserName = Utility.parseParameters(sUserName);
		sPassword = Utility.parseParameters(sPassword);
		oLoginBtn = Utility.parseParameters(oLoginBtn);
		wait = Utility.parseParameters(wait);
		ManageCompanyURL = Utility.parseParameters(ManageCompanyURL);
		
		Selenium_Object.launchPage(LoginURL);
		Selenium_Object.locationShouldContain(sProtocol);
		Selenium_Object.login(oUserName,oPassword,sUserName,sPassword,oLoginBtn);
		Selenium_Object.sleepTime(wait);
		Selenium_Object.launchPage(ManageCompanyURL);
		Selenium_Object.locationShouldContain(sProtocol);
	}
	
	@Parameters ({})
	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception 
	{
	}
}
