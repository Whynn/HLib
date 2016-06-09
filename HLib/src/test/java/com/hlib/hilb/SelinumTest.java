package com.hlib.hilb;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelinumTest {

	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/hilb/");
		
		driver.findElement(By.name("ID")).sendKeys("admin");
		driver.findElement(By.name("PW")).sendKeys("admin");
		driver.findElement(By.name("loginButton")).click();
		
		assertEquals("Manager Page", driver.getTitle());
	}
	
	@Test
	public void returnRequestTest(){
		
	}
	
	@Test
	public void selectGoodUserTest(){
		
	}
}
