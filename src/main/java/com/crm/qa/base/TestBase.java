package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("/Users/dipak/eclipse-workspace/FreeCRMTest"
					+ "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}
