package com.stormnet.base;

import com.codeborne.selenide.Configuration;
import com.stormnet.page.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1400x920";
        Configuration.browserPosition = "200x20";
        Configuration.headless = false;
        Configuration.savePageSource = false;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(CHROME);
        final ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("enableVNC", true);
        Configuration.fastSetValue = true;
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    public void startPage(){
        open("/");
    }

}
