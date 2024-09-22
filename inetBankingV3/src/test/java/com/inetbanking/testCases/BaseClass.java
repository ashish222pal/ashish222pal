package com.inetbanking.testCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApllicationURL();
	public String userName = readconfig.getuserName();
	public String Password = readconfig.getpassword();
    public static WebDriver driver; 
	public static  Logger logger;
	

		// OR for property file, should use any one of these
		//PropertyConfigurator.configure("myapp-log4j.properties");
	
	@BeforeClass
	public void SetUp()
	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
		 logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void TearDown()
	
	{
	driver.quit();	
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}