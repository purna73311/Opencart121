package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPge;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	
	
	
	{
		logger.info("*****  Starting TC_002_LoginTest *****");
		//Home Page
		try
		{
		Homepage hp=new Homepage(driver); // driver we passed comes from base class and passing to homepage class
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login Page
		LoginPge Lp=new LoginPge(driver);
		Lp.setEmail(p.getProperty("email"));
		Lp.txtPassword(p.getProperty("password"));
		Lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
{
	Assert.fail();
	}
	logger.info("***** Finished TC_002_LoginTest");
	}
	

}
