package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class OpenGoogle  {
WebDriver wd;

@BeforeClass
public void setUp(){
     wd = new ChromeDriver();
     wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     wd.get("https://www.google.com/");
}
@Test
public void testOpenGoogle() throws InterruptedException {

     wd.findElement(By.className("gb_D")).click();
     wd.findElement(By.className("gb_D")).click();
     Thread.sleep(3000);
}

    @Test
    public void testSearchGoogle(){

        wd.findElement(By.name("q")).click();
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("Java");
    }
@AfterClass
public void tearDown(){
  wd.quit();

}
}
