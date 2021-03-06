package com.telran.qa.second;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    WebDriver wd;

    //@BeforeMethod
   @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearch(){
        type(By.name("q"), "WebDriver"+ Keys.ENTER);
        click(By.cssSelector("[href='https://www.selenium.dev/documentation/en/webdriver/']"));
        back();
        //Assert.
    }

    public void back() {
        wd.navigate().back();
    }

    @Test
    public void testSearchImg(){
       String attribute = wd.findElement(By.name("q")).getAttribute("maxlength");
        System.out.println(attribute);
        Assert.assertEquals(attribute, "2048");
        final List<WebElement> div= wd.findElements(By.tagName("div"));
//        type(By.name("q"), "Java"+Keys.ENTER);
//        click(By.cssSelector("[data-hveid='CAEQAw']"));
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

   @AfterClass
   //@AfterMethod
    public void tearDown(){
        wd.quit();
    }


}
