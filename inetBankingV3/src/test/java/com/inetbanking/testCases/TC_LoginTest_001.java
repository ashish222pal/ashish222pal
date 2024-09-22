package com.inetbanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

  {
    @Test
	public void loginTest() throws IOException
	
	{
		driver.get(baseURL);
		logger.info("URL Opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("UserName Entered Successfully");
		lp.setPassword(Password);
		logger.info("Password Entered Successfully");
		lp.clickSubmit();
		
//		 System.out.println("Page title is : " + driver.getTitle());		
		
	if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
   {
   	Assert.assertTrue(true);
   	logger.info("TC_LoginTest_001 PASSED");
   	}
	else 
		{
		captureScreen(driver, "loginTest");
	    Assert.assertTrue(false);
	}
	}

  }
