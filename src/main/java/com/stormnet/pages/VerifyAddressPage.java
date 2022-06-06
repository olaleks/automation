package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerifyAddressPage {

    private SelenideElement proceedAddressBtn = $(".cart_navigation>button[name=\"processAddress\"]");

    public ShippingPage clickProceedAddressBtn() {
        proceedAddressBtn.click();
        return new ShippingPage();
    }
}
