package com.smava.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class SmavaTestBase {
	public static WebDriver driver;
	public static Properties prop;
   	static File propertiesfilepath=  new File("./src/main/java/com/smava/config"); 
	
   	
	@BeforeTest
	public static void Initialization () {
		
		prop= new Properties();	
		try {
			
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/smava/config/config.properties");
           
            try {
				prop.load(ip);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			System.setProperty(prop.getProperty("chromeDriver"),System.getProperty("user.dir")+"/src/main/java/com/smava/config/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		 
				  
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
				  
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
		
		}

}
