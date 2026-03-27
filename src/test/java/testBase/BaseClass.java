package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
//import java.util.logging.LogManager;//log4j
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseClass {
	public WebDriver driver;
	public Logger logger; // this is log4j
	public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(@Optional("Windows")String os, @Optional("chrome")String br) throws IOException
	{
		FileInputStream file=new FileInputStream("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass()); // this is for log4j2 code
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("Invalid browser name.."); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl2"));//reading url from properties file
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
    public void teardown()
    {
    	driver.quit();
    }
	
	public String randomeString()
    {
    	String generatedstring=RandomStringUtils.randomAlphanumeric(5);
    	return generatedstring;
    	
    }
	public String randomeNumber()
    {
    	String generatednumber=RandomStringUtils.randomNumeric(10);
    	return generatednumber;
    }
	public String randomeAlphaNumeric()
    {
    	String generatedstring=RandomStringUtils.randomAlphabetic(3);
    	String generatednumber=RandomStringUtils.randomNumeric(3);
    	return (generatedstring+"@"+generatednumber);
    	
    }
}
