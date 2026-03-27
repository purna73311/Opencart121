package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	public Homepage(WebDriver driver)
	{
		super(driver);
		/* This is PageObject Homepage extended from basepage when we extended basepage whatecer constructors
		 and varaibles created in basepage which belongs to homepage. In homepage we created another constructor 
		 without creating homepage constructor we cannot invoke basepage constructor this is inheritance(re-usability)
		 From the child class how we invoke the parent class constructor by using super keyword we can invoke imeediate
		 parent class constructor we can invoke,immediate parent varaibles we can invoke and methods also we can invoke by using  super keyword
		 Here in this class we created homepage constructor using classname, expecting driver from the test case 
		 later we will pass this driver and instead of doing pagefactory.initelents we are passing the same driver 
		 to the parent class constructor and inside the parent class constructor recieve the driver and initiate the driver
		 */
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	// This Element for login
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement linkLogin;
public void clickMyaccount()
{
	lnkMyaccount.click();
}
public void clickRegister()
{
	lnkRegister.click();
}
public void clickLogin()
{
	linkLogin.click();
}
}
