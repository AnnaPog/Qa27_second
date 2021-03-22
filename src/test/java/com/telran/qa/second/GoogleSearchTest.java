package com.telran.qa.second;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    WebDriver wd;

    @Test
    public void testGoogleSearch(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.google.ru");


        wd.findElement(By.name("q")).click();
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("WebDriver"+ Keys.ENTER);

        wd.findElement(By.cssSelector("[href='https://www.selenium.dev/documentation/en/webdriver/']")).click();


    }
}
