package com.stormnet.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Browsers.CHROME;

public abstract class BaseTest {
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
}
