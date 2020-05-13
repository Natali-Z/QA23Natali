package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        wd.findElement(By.name("os_username")).click();
        wd.findElement(By.name("os_username")).clear();
        wd.findElement(By.name("os_username")).sendKeys("Natali");

        wd.findElement(By.name("os_password")).click();
        wd.findElement(By.name("os_password")).clear();
        wd.findElement(By.name("os_password")).sendKeys("225656565");

      Thread.sleep(3000);

        wd.findElement(By.id("login")).click();

    }
        @AfterClass
                public void tearDown(){
    wd.quit();
        }
    }

