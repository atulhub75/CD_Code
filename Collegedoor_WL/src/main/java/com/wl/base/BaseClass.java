package com.wl.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wl.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static  WebDriver driver;
	public static Properties prop;
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
	}
	
	@BeforeTest
	public void loadConfig() {
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Resources\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	 public static void setup() 
     {
		 
		 
		 WebDriverManager.chromedriver().setup();
		 String browserName=prop.getProperty("browser");
		 
   	      if(browserName.equalsIgnoreCase("chrome"))
   			{
   	    	  ChromeOptions option= new ChromeOptions();
   	    	  option.addArguments("--remote-allow-origins=*");
   	    	  
   	    	  WebDriverManager.chromedriver().setup();
   	    	  driver=new ChromeDriver(option);
   	    	
        		    
   			}
   	      else if(browserName.equalsIgnoreCase("edge"))
   	      {
   	    	  WebDriverManager.edgedriver().setup();
   	    	  driver=new EdgeDriver();
        		   
   	      }
   	      else if(browserName.equalsIgnoreCase("firefox"))
   	      {
   	    	  WebDriverManager.firefoxdriver().setup();
      	    	  driver=new FirefoxDriver();
        		    
   	      }
   	      
   	      driver.manage().window().maximize();
   	      driver.manage().deleteAllCookies();
   	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
   	      driver.get(prop.getProperty("appURL"));
  	
     }
	 
	    //@AfterClass
	    public void teadDown()
	    {
	   	driver.quit(); 
	     }
	    
	    @AfterSuite
	    public void afterSuite() {
			ExtentManager.endReport();
		}
	
	
}
