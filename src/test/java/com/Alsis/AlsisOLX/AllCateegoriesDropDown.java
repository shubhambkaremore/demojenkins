package com.Alsis.AlsisOLX;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllCateegoriesDropDown {
	WebDriver driver;

	@Test
	public void Categoriesdropdown() throws Exception {
		System.setProperty("webdriver.chrome.driver", "//E://workspace3//AlsisOLX//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Check wether india  is present or not
		String LocationBarExpValue = driver.findElement(By.xpath("//input[@class='_1jABB']")).getAttribute("value");
	    System.out.println(LocationBarExpValue);
	   
	    //click on location bar  drop down
	    WebElement Locationbar = driver.findElement(By.xpath("//input[@class='_1jABB']"));
		Locationbar.click();
		
		//check for ghost text
		String ghosttext = driver.findElement(By.xpath("//input[@class='_1jABB']")).getAttribute("placeholder");
		System.out.println(ghosttext);
		
		//check wether popular location text present or not
		String Textpresent = driver.findElement(By.xpath("//span[contains(text(),'Popular locations')]")).getText();
		System.out.println(Textpresent);
		
		//click on your Location row
		driver.findElement(By.xpath("//span[contains(text(),'Use current location')]")).click();
	
		Thread.sleep(5000);
		
	    //click on all categories
       driver.findElement(By.xpath("//div[@data-aut-id='allCategories']")).click();		
		
       
       //click on Electronics & Appliances  from the drop down menu of all categories
       driver.findElement(By.xpath("//span[contains(text(),'ACs')]//ancestor::a[@class='_2fitb']")).click();
       
       Thread.sleep(5000);
       
       String addsno=driver.findElement(By.xpath("//*[@id='adsResultsCurrentLocation']")).getText();
		System.out.println(addsno);
		
		String[] Ay = addsno.split(" ");
		System.out.println(Ay[0]);
  
		int intaddno=Integer.parseInt(Ay[0]);
		boolean Flag=false;
		
		if (intaddno>=3) {
			System.out.println("TC002 Passed :Ads no. greater than 3");
			Flag=true;
			
		}
		else System.out.println("TC002 Passe :Ads no. less than 3");
		Assert.assertTrue(Flag);
		driver.quit();
		
	
	
	}
}
