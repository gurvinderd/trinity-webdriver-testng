package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BookFlightTestNG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBookFlightTestNG() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("mercury");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("mercury");
    driver.findElement(By.name("login")).click();
    new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Frankfurt");
    new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("May");
    new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("15");
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("June");
    new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("15");
    driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
    driver.findElement(By.name("findFlights")).click();
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.name("reserveFlights")).click();
    driver.findElement(By.name("passFirst0")).clear();
    driver.findElement(By.name("passFirst0")).sendKeys("Gurvinder");
    driver.findElement(By.name("passLast0")).clear();
    driver.findElement(By.name("passLast0")).sendKeys("Dhillon");
    driver.findElement(By.name("passFirst1")).clear();
    driver.findElement(By.name("passFirst1")).sendKeys("MyName");
    driver.findElement(By.name("passLast1")).clear();
    driver.findElement(By.name("passLast1")).sendKeys("Dhillon");
    new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Hindu");
    new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Vegetarian");
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
    driver.findElement(By.cssSelector("a > img")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
