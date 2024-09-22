package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() 
	
	{
		File src = new File("./Configuration/Config.properties");
		try 
		{
			FileInputStream fis = new 	FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
		System.out.println("Exception is" + e.getMessage());
		}
	}
		
		public String getApllicationURL()
		
		{
			String url = pro.getProperty("baseURL");
			return url;
		}
		
       public String getuserName()
		
		{
			String userName = pro.getProperty("userName");
			return userName;
		}
       
       public String getpassword()
		
   		{
   			String password = pro.getProperty("password");
   			return password;
   		}
		
       
       public String getChromePath()
		
   		{
   			String chromepath = pro.getProperty("chromepath");
   			return chromepath;
   		}
		
	}	


