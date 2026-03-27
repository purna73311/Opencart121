package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPssword;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    public void setTelephone(String phone)
    {
    	txtTelephone.sendKeys(phone);
    }
    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    public void setConfirmPassword(String pwd)
    {
    	txtConfirmPssword.sendKeys(pwd);
    }
    public void checkButton()
    {
    	chkdPolicy.click();
    }
    public void clickContine() {
    	btnContinue.click();
    	// If click button not work we need to alternate ways
    	
    	//sol1
    	//btnContinue.submit();
    	
    	// sol2
    	// Actions act=new Actions(driver);
    	//act.moveToElement(btnContinue).click().perform();
    	
    	//sol3
    	//btnContinue.sendKeys(Keys.RETURN);
    	
    	//sol4
    	//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    }	
    	public String getConfirmation() {
    		try {
    			return (msgConfirmation.getText());
    		}
    		catch(Exception e)
    		{
    			return(e.getMessage());
    		}
    	
    	
    }
    
}
