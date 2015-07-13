/*
TC Title : General  - Unauthenticated user - Always redirected to the login page if not logged in
Date : 6/3/2015 2:36:07 PM
Author : Nguyen Dong
Design Step : 
*** TEST OBJECTIVE
Verify that an unauthenticated user cannot view anything except the login page. No matter what resource they try to access in the portal they should be redirected to the login page if they am not logged in
*** HOW TO RUN THE TEST
1. Open web browser.
2. Access to https://qa-omv.sixsolutions.us (home Page)
3. Verify URL is re-directed
4. Access to https://qa-omv.sixsolutions.us/Admin (Admin Main Page)
5. Verify URL is re-directed
*** EXPECTED RESULTS:
The access will be re-directed to login page.

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
public class GUI0005
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
	
	@Parameters ({"HomePageURL","expected","AdminMainPage"})
	@Test(alwaysRun = true)
	public void GUI0005(String HomePageURL,String expected,String AdminMainPage) throws Exception 
	{
		HomePageURL = Utility.parseParameters(HomePageURL);
		expected = Utility.parseParameters(expected);
		AdminMainPage = Utility.parseParameters(AdminMainPage);
		
		Selenium_Object.launchPage(HomePageURL);
		Selenium_Object.locationShouldContain(expected);
		Selenium_Object.launchPage(AdminMainPage);
		Selenium_Object.locationShouldContain(expected);
	}
	
	@Parameters ({})
	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception 
	{
	}
}
