package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
  WebDriver wd;
  WebDriverWait wait;


  @BeforeMethod
  public void setUp() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd,40);
    wd.manage().window().maximize();
    wd.navigate().to("https://trello.com/");
  }

  @Test
  public void testBoardCreation() {
//unit login
    unitLogin();
    fillLoginFromAtlassianAcc("znatali1118@gmail.com", "natali5756");
    confirmLogin();
  }

  private void confirmLogin() {
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click();
    click(By.id("login-submit"));
  }

  private void fillLoginFromAtlassianAcc(String userEmail, String password) {

    type(By.name("user"), userEmail);
    click(By.cssSelector("#login.button-green"));
    type(By.cssSelector("input#password"), password);
  }

  private void unitLogin() {
    click(By.cssSelector("[href='/login']"));
  }

  private void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  private void click(By locator) {
    wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
  }

  //@AfterMethod
  public void tearDown() {
   wd.quit();

  }

}
