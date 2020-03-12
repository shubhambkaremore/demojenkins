package com.Alsis.AlsisOLX;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerachBarTest {
	WebDriver driver;
	
	int minadsno=3;

	@Test
	public void SearchTest() throws Exception {
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
		
		driver.findElement(By.xpath("//span[contains(text(),'Your location')]")).click();
		
		Thread.sleep(5000);
        
		//click on search Tab highlight
		
		driver.findElement(By.xpath("//input[@data-aut-id='searchBox']")).click();
		
		//click on search tabs ghost text
		
		String searchtabghost=driver.findElement(By.xpath("//input[@data-aut-id='searchBox']")).getAttribute("placeholder");
		System.out.println(searchtabghost);
	
		//Enter text AC in Searchbox
		
		driver.findElement(By.xpath("//input[@data-aut-id='searchBox']")).sendKeys("AC");
	    Thread.sleep(5000);
		
	    //select ACs from dropdown auto suggestion 
		
	    driver.findElement(By.xpath("//ul[@role='listbox']//li[1]")).click();
		Thread.sleep(8000);
		
		//check the text of ac landing page
		    String acpageheader=driver.findElement(By.xpath("//h1[contains(text(),'Karve Nagar')]")).getText();
			System.out.println(acpageheader);
		     Thread.sleep(3000);
			//
	String noofadds =	driver.findElement(By.xpath("//p[@id='adsResultsCurrentLocation']")).getText();
		System.out.println(noofadds);
		
		String[] Sp = noofadds.split(" ");
		System.out.println(Sp[0]);
		int adnumber=Integer.parseInt(Sp[0]);
		boolean Flag = false;
		
		if (adnumber>=minadsno) {
		System.out.println("=========Testcase(TC001) Passed===========");
		Flag=true;
			
		}
		else System.out.println("=========Testcase(TC001) Failed===========");
		Assert.assertTrue(Flag);	
	driver.quit();
	}
	
}