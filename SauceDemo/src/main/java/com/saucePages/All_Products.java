package com.saucePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class All_Products extends Authentication{

	public All_Products(WebDriver rdriver) {
		super(rdriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@class=\"app_logo\"]")
	public WebElement swagLabsName;
	
	@FindBy(xpath="//*[@id=\"item_4_img_link\"]")
	public WebElement firstProductImage;

	@FindBy(xpath="(//*[text()=\"Add to cart\"])[1]")
	public WebElement addToCartButton;
	
	@FindBy(xpath="//*[@class=\"inventory_item_price\"]")
	public WebElement productPrice;
	
	@FindBy(xpath="//*[@class=\"inventory_details_desc_container\"]")
	public WebElement productDiscription;
	
	@FindBy(id="back-to-products")
	public WebElement backToProductButton;
	
	@FindBy(id="remove-sauce-labs-backpack")
	public WebElement removeBagPackButton;
	
	@FindBy(id="checkout")
	public WebElement checkoutButton;
	
	@FindBy(xpath="//*[@class=\"shopping_cart_link\"]")
	public WebElement mycart;
}
