package com.generic.SauceDemo;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pom.sauceDemo.CartPage;
import com.pom.sauceDemo.CheckOutPage;
import com.pom.sauceDemo.ConfirmatrionPage;
import com.pom.sauceDemo.HomePage;
import com.pom.sauceDemo.OrderSummaryPage;
@Listeners(com.generic.SauceDemo.ListenerImlementation.class)
public class TC_001 extends BaseClass {
	@Test
	public void e2eScenario() throws InterruptedException, EncryptedDocumentException, IOException
	{

		FileLib file=new FileLib();
		String homeUrl = file.getExcelData("SauceData", 10, 0);

		String currentUrl = driver.getCurrentUrl();

		//		Assert.assertEquals(homeUrl, currentUrl);

		//Home Page Validation using page URL.
		if(homeUrl.equals(currentUrl))
		{
			Reporter.log("Successfully Login", true);
			Reporter.log("Home page is successfully Displayed", true);
		}
		else
		{
			Reporter.log("Home page is not Validated", true);
			Assert.fail();
		}


		HomePage hp=new HomePage(driver);

		hp.setCart();

		CartPage cart=new CartPage(driver);

		List<WebElement> products = cart.getCartProducts();
		//		boolean cartValidate=true;
		//		 String firstProdPrice = cart.getFirstProdPrice().getText();
		//		 String secondProdPrice = cart.getSecondProdPrice().getText();
		
		
		Map<String, String> cartActualProducts=new LinkedHashMap<String, String>();
		Map<String, String> cartExpectedProducts=new LinkedHashMap<String, String>();
		cartActualProducts.put(products.get(0).getText(), cart.getFirstProdPrice().getText());
		cartActualProducts.put(products.get(1).getText(), cart.getSecondProdPrice().getText());


		//		String expectedProduct1 = file.getExcelData("SauceData", 13, 0);
		//		String expectedProduct2 = file.getExcelData("SauceData", 13, 1);
		//		String expectedPrice1 = file.getExcelData("SauceData", 16, 0);
		//		String expectedPrice2 = file.getExcelData("SauceData", 16, 1);


		cartExpectedProducts.put(file.getExcelData("SauceData", 13, 0), file.getExcelData("SauceData", 16, 0));
		cartExpectedProducts.put(file.getExcelData("SauceData", 13, 1), file.getExcelData("SauceData", 16, 1));

		//Validating cart with both products and price.
		if(cartActualProducts.equals(cartExpectedProducts))
		{
			Reporter.log("Products are successfully added to Cart", true);
		}
		else
		{
			Reporter.log("Cart products Mismatch", true);
			Assert.fail();
		}

		//Validating the cart only with products.

		//String product1 = file.getExcelData("SauceData", 13, 0);
		//String product2 = file.getExcelData("SauceData", 13, 1);
		
		//		for(WebElement item:products)
		//		{
		//			String prodName =item.getText();
		//			if(!(prodName.equals(product1) || prodName.equals(product2))) {
		//				cartValidate=false;
		//				Reporter.log("Cart products Mismatch", true);
		//				Assert.fail();
		//			}
		//		}
		//		if(cartValidate)
		//		{
		//			Reporter.log("Cart is successfully validated", true);
		//		}

		cart.getCheckoutBtn().click();

		CheckOutPage checkOut=new CheckOutPage(driver);

		String firstName = file.getExcelData("SauceData", 7, 0);
		String lastName = file.getExcelData("SauceData", 7, 1);
		String zipCode = file.getExcelData("SauceData", 7, 2);

		//	 checkOut.getFirstNameTbx().sendKeys(firstName);
		//	 checkOut.getLastNameTbx().sendKeys(lastName);
		//	 checkOut.getZipCodeTbx().sendKeys(zipCode);

		checkOut.setCheckOut(firstName, lastName, zipCode);

		OrderSummaryPage orderPage=new OrderSummaryPage(driver);

		String actualTotal = orderPage.getTotalPrice().getText();
		String expectedTotal = file.getExcelData("SauceData", 19, 0);

		List<WebElement> actualOrdProd = orderPage.getFinalProducts();
		Map<String, String> ordActualProducts=new LinkedHashMap<String, String>();

		ordActualProducts.put(actualOrdProd.get(0).getText(), orderPage.getFirstProdPrice().getText());
		ordActualProducts.put(actualOrdProd.get(1).getText(), orderPage.getSecondProdPrice().getText());
		
		//Order Summary Page Validation.
		if(ordActualProducts.equals(cartExpectedProducts) && actualTotal.equals(expectedTotal))
		{
			Reporter.log("Successfully Created Order Summary", true);;
		}
		else
		{
			Reporter.log("Order Summary Mismatch", true);
			Assert.fail();
		}

		orderPage.getFinishBtn().click();

		ConfirmatrionPage confirm=new ConfirmatrionPage(driver);

		String confirmMsg = confirm.getVerifyMsg().getText();

		Reporter.log(confirmMsg, true);

	}


}

