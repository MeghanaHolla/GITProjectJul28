package com.demoaut.newtours.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.SignOn;

import utils.GenericMethods;

public class VerifyInvalidCredentialsTest {
	WebDriver driver;
	@BeforeTest
	
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void verifyInvalidCredentails() throws IOException {
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);

		String[][] data = GenericMethods.getData("D:\\SelJun30\\TestData.xlsx", "Sheet1");

		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][1],data[i][2]);
			boolean signOnLinkVisible = so.verifySignOnLinkVisibility();
			Assert.assertTrue(signOnLinkVisible);
			driver.navigate().back();
		}
	}

}
