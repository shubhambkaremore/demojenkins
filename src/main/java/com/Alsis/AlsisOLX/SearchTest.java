package com.Alsis.AlsisOLX;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "//E://workspace3//OfflineWebsiteSirTask//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.olx.in/");
	    driver.manage().window().maximize();
    // WebElement Locationbar = driver.findElement(By.xpath("//*[@id='container']/header/div/div/div[2]/div/div/div[1]/div/div/input"));

     //Locationbar.click();
     //Locationbar.clear();
	}
}