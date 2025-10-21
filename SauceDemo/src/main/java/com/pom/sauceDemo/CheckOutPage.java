package com.pom.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {



	@FindBy(id="first-name")
	private WebElement firstNameTbx;

	@FindBy(id="last-name")
	private WebElement lastNameTbx;

	@FindBy(id="postal-code")
	private WebElement zipCodeTbx;

	@FindBy(id="continue")
	private WebElement continueBtn;


	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setCheckOut(String firstName,String lastName,String zipCode) {


		firstNameTbx.sendKeys(firstName);
		lastNameTbx.sendKeys(lastName);
		zipCodeTbx.sendKeys(zipCode);
		continueBtn.click();


	}











	//	public WebElement getFirstNameTbx() {
	//		return firstNameTbx;
	//	}
	//
	//	
	//	public WebElement getLastNameTbx() {
	//		return lastNameTbx;
	//	}
	//
	//	
	//	public WebElement getZipCodeTbx() {
	//		return zipCodeTbx;
	//	}
	//
	//	
	//	public WebElement getContinueBtn() {
	//		return continueBtn;
	//	}

}
