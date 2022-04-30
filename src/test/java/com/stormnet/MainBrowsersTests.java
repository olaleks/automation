package com.stormnet;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.*;

public class MainBrowsersTests {
  @Test
  public void openPageGoogleSelenium() {
    System.setProperty("webdriver.chrome.driver", "/Users/olgasalachyonok/Downloads/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    driver.close();
  }

  @Test
  public void openGooglePageSelenide() {
    open("http://automationpractice.com/index.php");
  }

  @Test
  public void openFirefoxPageSelenium() {
    System.setProperty("webdriver.gecko.driver", "/Users/olgasalachyonok/Downloads/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get("http://automationpractice.com/index.php");
    driver.close();
  }

  @Test
  public void openFirefoxPageSelenide() {
    Configuration.browser = "firefox";
    open("http://automationpractice.com/index.php");
  }

  @Test
  public void checkPlaceholder() {
    String expectedPlaceholder = "Search";
    open("http://automationpractice.com/index.php");
    String actualPlaceholder = $("#search_query_top").getAttribute("placeholder");
    Assertions.assertEquals(expectedPlaceholder, actualPlaceholder);//или без Assertions вариант
//    if (actualPlaceholder.equals(expectedPlaceholder)) {
//      System.out.println("Passed!");
//    } else {
//      System.out.println("Failed!");
//    }
  }
}
