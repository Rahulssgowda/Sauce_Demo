package com.pom.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



	@FindBy(id="user-name")
	private WebElement unTbx;

	@FindBy(id="password")
	private WebElement pwdTbx;

	@FindBy(id="login-button")
	private WebElement lgnBtn;


	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void setLogin(String un,String pw)
	{
		unTbx.sendKeys(un);
		pwdTbx.sendKeys(pw);
		lgnBtn.click();
	}
}


