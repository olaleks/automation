package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement sighInButton = $(".login");

    public LoginPage clickSignInButton() {
        sighInButton.click();
        return new LoginPage();
    }
}
