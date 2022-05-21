package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShippingPage {
    private SelenideElement agreeTermsCheckBox = $("#cgv");
    private SelenideElement processCarrierBtn= $("button[name=\"processCarrier\"]");

    public ShippingPage selectAgreeTermsCheckBox() {
        agreeTermsCheckBox.click();
        return this;
    }
    public PaymentPage clickProcessCarrierBtn(){
        processCarrierBtn.click();
        return new PaymentPage();
    }
}
