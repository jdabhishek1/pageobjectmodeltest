package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//td[text()='Abhishek Deshpande']//preceding-sibling::td")
	WebElement contactsLabel1;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//child::input[@class='search']")
	WebElement companyName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//child::i[@class='save icon']")
	WebElement saveBtn;
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td")).click();	
	}
	
	public boolean CheckBoxSelected(String name){
		return driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td")).isSelected();
	}
	
	public void createNewContact(String fName, String lName, String company){
		newContact.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		companyName.sendKeys(company);
		saveBtn.click();
	}

}
