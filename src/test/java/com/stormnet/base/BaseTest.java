package com.stormnet.base;

import com.codeborne.selenide.Configuration;
import com.stormnet.ConfigLoader;
import com.stormnet.ConfigModel;
import com.stormnet.pages.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    protected HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUp() {
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


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        //capabilities.setBrowserName(CHROME);
//        final ChromeOptions options = new ChromeOptions();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability("enableVNC", true);
//
//        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    public void startPage(){
        open("/");
    }

}
