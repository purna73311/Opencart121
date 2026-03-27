package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPge;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	/*
	 * Data is valid --login sucess-test pass--logout --login failed--test fail
	 * 
	 * Data is invalid --login success--test fail--logout --login failed -- test
	 * pass
	 */
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp){
		//Home page
		logger.info("***** Completed TC_003_LoginDDT ******");
		try
		{
	Homepage hp=new Homepage(driver); // driver we passed comes from base class and passing to homepage class
	hp.clickMyaccount();
	hp.clickLogin();
	
	//Login Page
	LoginPge Lp=new LoginPge(driver);
	Lp.setEmail(email);
	Lp.txtPassword(pwd);
	Lp.clickLogin();
	
	//MyAccount
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	if(exp.equalsIgnoreCase("valid"));
	{
	if(targetPage==true)
	{
		Assert.assertTrue(true);
		macc.clickLogout();
	}
	else
	{
		Assert.assertTrue(false);
	}
	
	}if(exp.equalsIgnoreCase("Invalid"));{
if(targetPage==true) {
	macc.clickLogout();
	Assert.assertTrue(false);
	
}
	else
	{
		Assert.assertTrue(true);
	}
	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	logger.info("****** Finished TC_003_LoginDDT ******");
}
}
