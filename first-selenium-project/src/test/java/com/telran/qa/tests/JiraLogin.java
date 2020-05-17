package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JiraLogin {

  WebDriver wd;

  @BeforeClass
  public void setup() {

    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.manage().window().maximize();

    //  wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
    wd.navigate().to("http://jira.tel-ran.net/secure/Dashboard.jspa");
  }

  @Test
  public void testJiraLogin() throws InterruptedException {

    type(By.name("os_username"), "Natali");
    type(By.name("os_password"), "225656565");

    Thread.sleep(3000);

    click(By.id("login"));

    Assert.assertTrue(isElementPresent(By.id("usernameerror")));

    String errorMessage = wd.findElement(By.id("usernameerror")).getText();

    Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  private void click(By username) {
    wd.findElement(username).click();
  }

  public boolean isElementPresent(By locator) {

    return wd.findElements(locator).size() > 0;

  }

  @AfterClass
  public void tearDown() {
    // wd.quit();
  }
}

