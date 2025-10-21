package com.pom.sauceDemo;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> cartProducts;

	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath ="(//div[@class='inventory_item_price'])[1]")
	private WebElement firstProdPrice;
	
	@FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
	private WebElement secondProdPrice;


	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);

	}

	public List<WebElement> getCartProducts() {
		return cartProducts;
	}
	public WebElement getFirstProdPrice() {
		return firstProdPrice;
	}

	
	public WebElement getSecondProdPrice() {
		return secondProdPrice;
	}


	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
}
