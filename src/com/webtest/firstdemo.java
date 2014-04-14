/**
 * 
 */
package com.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author gurvinderd
 * This is first demo class for Webdriver
 */
public class firstdemo {

	/**
	 * @param args
	 * @throws InterruptedException : thread.sleep throws exception
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		String baseUrl;
		baseUrl = "http://newtours.demoaut.com/";
		driver.get(baseUrl + "/");
		
		//Login
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
		// select nbr of tickets
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
		
		//select from-to flight, date, class, and airline preference
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
		new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("May");
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("15");
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
		new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("June");
		new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("15");
		driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name=\"findFlights\"]")).submit();
		Thread.sleep(1000);
		driver.findElement(By.name("reserveFlights")).click();
		
		// enter passenger detail
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("Gurvinder");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Dhillon");
		driver.findElement(By.name("passFirst1")).clear();
		driver.findElement(By.name("passFirst1")).sendKeys("MyName");
		driver.findElement(By.name("passLast1")).clear();
		driver.findElement(By.name("passLast1")).sendKeys("Dhillon");
		
		//enter meal preference
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Hindu");
		new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Vegetarian");
		
		// enter credit card information
		new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("MasterCard");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("1234567890");
		new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("03");
		new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");
		driver.findElement(By.name("cc_frst_name")).clear();
		driver.findElement(By.name("cc_frst_name")).sendKeys("FirstN");
		driver.findElement(By.name("cc_mid_name")).clear();
		driver.findElement(By.name("cc_mid_name")).sendKeys("M");
		driver.findElement(By.name("cc_last_name")).clear();
		driver.findElement(By.name("cc_last_name")).sendKeys("LastN");
		driver.findElement(By.name("buyFlights")).click();
		System.out.println("flight booked");
		
		//return to flight booking page
		driver.findElement(By.cssSelector("a > img")).click();
		System.out.println("new booking page");
		driver.close();
		driver.quit();
	}

}
