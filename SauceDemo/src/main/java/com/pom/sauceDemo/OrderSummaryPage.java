package com.pom.sauceDemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

	@FindBy(className = "inventory_item_name")
	private List<WebElement> finalProducts;

	@FindBy(xpath ="(//div[@class='inventory_item_price'])[1]")
	private WebElement firstProdPrice;

	@FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
	private WebElement secondProdPrice;

	@FindBy(className ="summary_total_label")
	private  WebElement totalPrice;



	@FindBy(id="finish")
	private WebElement finishBtn;


	public OrderSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}



	public List<WebElement> getFinalProducts() {
		return finalProducts;
	}

	public WebElement getFirstProdPrice() {
		return firstProdPrice;
	}

	public WebElement getSecondProdPrice() {
		return secondProdPrice;
	}


	public WebElement getTotalPrice() {
		return totalPrice;
	}


	public WebElement getFinishBtn() {
		return finishBtn;
	}

}
