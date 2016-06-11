package com.hlib.hilb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelinumTest {

	static WebDriver driver;
	
	@BeforeClass
	public static void arrangeClass() {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void aLoginTest() {
		System.out.println("start LoginTest()");
		
		driver.get("http://localhost:8080/hilb/");
		
		driver.findElement(By.name("ID")).sendKeys("admin");
		driver.findElement(By.name("PW")).sendKeys("admin");
		
		driver.findElement(By.name("loginButton")).click();
		
		assertEquals("Manager Page", driver.getTitle());
		//System.out.println("end LoginTest()");
	}
	
	// 우수 이용자 테스트
	@Test
	public void bSelectGoodUserTest(){
		System.out.println("start electGoodUserTest()");
		
		driver.findElement(By.name("selectButton")).click();
		
		assertEquals("http://localhost:8080/hilb/select", driver.getCurrentUrl());
		
	}
}
