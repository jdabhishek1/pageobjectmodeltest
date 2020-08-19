package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement loginLink;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(xpath="//img[contains(@alt,'Cogmento')]")
	WebElement crmLogo;
	
	//Initilaizing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this); //initilize all objects of current class using 'this' or LoginPage.class
		
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		loginLink.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	

}
