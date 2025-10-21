package com.pom.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmatrionPage {


	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	private WebElement verifyMsg;



	public ConfirmatrionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyMsg() {
		return verifyMsg;
	}


}
