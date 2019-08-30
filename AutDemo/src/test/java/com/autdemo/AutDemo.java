package com.autdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AutDemo {
  
	
	Properties  pro = new Properties();
	Properties loc = new Properties();

	 FileInputStream fl;

	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\mohit.jaiswal\\Desktop\\Selenium\\AutDemo\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
       

	try {
	fl = new FileInputStream("./com.Testdata/input.properties");
	} catch (FileNotFoundException e) {

	e.printStackTrace();
	}


	FileInputStream input = new FileInputStream("./Locators/Locators.properties");

	loc.load(input);
	pro.load(fl);
	

		driver.get(loc.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		}

		@Test(priority=1)
		public void login()
		{
		String dateFromTestData = "Aug 30, 2019";

		WebElement actualDateFromUi = driver.findElement(By.xpath("//b[text()='"+dateFromTestData+"']"));

		String actualDateFromUiString = actualDateFromUi.getText();

		Assert.assertEquals(dateFromTestData, actualDateFromUiString);

    
	
		driver.findElement(By.xpath(loc.getProperty("User_Name"))).sendKeys(pro.getProperty("username"));
		driver.findElement(By.xpath(loc.getProperty("Password"))).sendKeys(pro.getProperty("passwd"));
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		
		
		//driver.findElement(By.xpath(loc.getProperty("radio_button1"))).click();
		driver.findElement(By.xpath(loc.getProperty("passcount"))).click();
		driver.findElement(By.xpath(loc.getProperty("port"))).click();
		//driver.findElement(By.xpath("//select[@name=\"fromMonth\"]")).click();
		Select s = new Select(driver.findElement(By.xpath(loc.getProperty("month1"))));
		s.selectByIndex(2);
		
		driver.findElement(By.xpath(loc.getProperty("date"))).click();
		driver.findElement(By.xpath(loc.getProperty("port2"))).click();
		driver.findElement(By.xpath(loc.getProperty("monththback"))).sendKeys("january");
		//driver.findElement(By.xpath("//"))
		driver.findElement(By.xpath(loc.getProperty("radio_choice"))).click();
		driver.findElement(By.xpath(loc.getProperty("preferaline"))).sendKeys("Unified Airlines");
		driver.findElement(By.xpath(loc.getProperty("continue"))).click();
		driver.findElement(By.xpath(loc.getProperty("radio_b1"))).click();
		driver.findElement(By.xpath(loc.getProperty("radio_b2"))).click();
		driver.findElement(By.xpath(loc.getProperty("reserve_flite"))).click();
		driver.findElement(By.xpath(loc.getProperty("firstname"))).sendKeys(pro.getProperty("fname"));
		driver.findElement(By.xpath(loc.getProperty("lastname"))).sendKeys(pro.getProperty("lname"));
		driver.findElement(By.xpath(loc.getProperty("type_flite"))).click();
		driver.findElement(By.xpath(loc.getProperty("creditcardtype"))).sendKeys(pro.getProperty("cardtype"));
		
		driver.findElement(By.xpath(loc.getProperty("creditcardno"))).sendKeys(pro.getProperty("cardno"));
		//driver.findElement(By.xpath("//input[@name=\"creditnumber\"]")).sendKeys("7860330089");
		driver.findElement(By.xpath(loc.getProperty("datetime")));
		Select s1=new Select(driver.findElement(By.xpath(loc.getProperty(pro.getProperty("datet2")))));
		s1.selectByIndex(2);
		Select s2 = new Select(driver.findElement(By.xpath(loc.getProperty("expyr"))));
		s2.selectByIndex(2);
		driver.findElement(By.xpath(loc.getProperty("fname"))).sendKeys(pro.getProperty("book_fname"));
		driver.findElement(By.xpath(loc.getProperty("midname"))).sendKeys(pro.getProperty("book_lname"));
		driver.findElement(By.xpath(loc.getProperty("lname"))).sendKeys(pro.getProperty("kname"));
		driver.findElement(By.xpath(loc.getProperty("check"))).click();
		driver.findElement(By.xpath(loc.getProperty("billadd"))).sendKeys(pro.getProperty("billadd"));
		driver.findElement(By.xpath(loc.getProperty("billcity"))).sendKeys(pro.getProperty("city"));
		driver.findElement(By.xpath(loc.getProperty("billstate"))).sendKeys(pro.getProperty("state"));
		driver.findElement(By.xpath(loc.getProperty("billzip"))).sendKeys(pro.getProperty("zip"));
		//driver.findElement(By.xpath("//select[@name=\"billCountry\"]//option[@value=\"1\"]"));
		driver.findElement(By.xpath(loc.getProperty("Addressdel"))).sendKeys(pro.getProperty("adress"));
		driver.findElement(By.xpath(loc.getProperty("book_reserve_buttton"))).click();
		
	
		try {
			Thread.sleep(10000);
			} catch (InterruptedException e) {

			e.printStackTrace();
			}

			}
			@AfterClass
			public void TearDown()
			{
			driver.quit();
			}
			
			
			}

	
	
	
