package com.stormnet.base;

import com.codeborne.selenide.Configuration;
import com.stormnet.ConfigLoader;
import com.stormnet.ConfigModel;
import com.stormnet.pages.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        ConfigLoader configLoader =new ConfigLoader();
        ConfigModel configModel = configLoader.getConfigModel();

        Configuration.baseUrl = configModel.getBaseUrl();
        Configuration.timeout = configModel.getTimeout();
        Configuration.browser = configModel.getBrowser();
        Configuration.browserSize = configModel.getBrowserSize();
        Configuration.browserPosition = configModel.getBrowserPosition();
        Configuration.headless = configModel.getHeadless();
        Configuration.savePageSource = configModel.getSavePageSource();
        Configuration.fastSetValue = configModel.getFastSetValue();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "101.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                capabilities
        );
        setWebDriver(driver);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    public void startPage(){
        open("/");
    }

}
