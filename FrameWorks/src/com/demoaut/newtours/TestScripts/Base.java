package com.demoaut.newtours.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Base {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void openApplication(String browser) {
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox")){
			System.setProperty("webdriver.geckodriver.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeApplication() {
		driver.close();
	}
	


}
