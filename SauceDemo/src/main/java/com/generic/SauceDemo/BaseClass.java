package com.generic.SauceDemo;



import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.pom.sauceDemo.HomePage;
import com.pom.sauceDemo.LoginPage;


public class BaseClass {
	public static ChromeOptions option;
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() 
	{
		option=new ChromeOptions();
		option.addArguments("--incognito");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		FileLib f= new FileLib();
		String url = f.getExcelData("SauceData", 1, 0);
		String un = f.getExcelData("SauceData", 4, 0);
		String pw = f.getExcelData("SauceData", 4, 1);
		//Thread.sleep(2000);
		driver.get(url);
		LoginPage lg=new LoginPage(driver);
		//Thread.sleep(2000);
		lg.setLogin(un, pw);
	}

	@AfterMethod
	public void logout() throws InterruptedException
	{

		//Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.setLogout();
		Reporter.log("Successfully Logout", true);
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.quit();
	}


}

