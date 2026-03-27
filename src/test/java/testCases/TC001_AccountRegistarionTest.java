package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistarionTest extends BaseClass {
	
    @Test(groups={"Regression","Master"})
    public void verify_account_registration()
    {
    	
    	logger.info("**** Starting TC001_AccountRegistarionTest *****");
    	try
    	{
    	Homepage hp=new Homepage(driver);
    	hp.clickMyaccount();
    	logger.info("Clicked on MyAccount Link");
    	hp.clickRegister();
    	logger.info("Clicked on Register Link");
    	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
    	regpage.setFirstName(randomeString().toUpperCase());
    	regpage.setLastName(randomeString().toUpperCase());
    	regpage.setEmail(randomeString()+"@gmail.com");
    	regpage.setTelephone(randomeNumber());
    	String password= randomeAlphaNumeric();
    	regpage.setPassword(password);
    	regpage.setConfirmPassword(password);
    	regpage.checkButton();
    	regpage.clickContine();
    	logger.info("Validating expected message");
    	String confmsg=regpage.getConfirmation();
    	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    	}
    	catch(Exception e)
    	{
    		logger.error("Test Failed...");
    		logger.debug("Debug logs..");
    		Assert.fail();
    	}
    	logger.info("**** This is Finished TC001_AccountRegistarionTest****");
    }
    }

   