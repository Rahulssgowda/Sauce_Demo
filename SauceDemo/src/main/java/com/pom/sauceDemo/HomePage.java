package com.pom.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//button[text()='Add to cart'][1]")
	private WebElement firstAddCartBtn;

	@FindBy(xpath = "//button[text()='Add to cart'][1]")
	private WebElement secondAddCartBtn;

	@FindBy(id= "shopping_cart_container")
	private WebElement cartBtn;

	@FindBy(id="react-burger-menu-btn")
	private WebElement burgerBtn;

	@FindBy(id="logout_sidebar_link")
	private WebElement lgOutBtn;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void setCart()
	{
		firstAddCartBtn.click();
		secondAddCartBtn.click();
		cartBtn.click();
	}


	public void setLogout() {
		burgerBtn.click();
		lgOutBtn.click();
	}

}
