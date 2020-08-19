package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException{
		contactsPage.selectContactsByName("Abhishek Deshpande");	
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException{
		contactsPage.selectContactsByName("Abhishek Deshpande");	
		contactsPage.selectContactsByName("J D");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact( String firtName, String lastName, String company){
		contactsPage.createNewContact(firtName,lastName,company);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
