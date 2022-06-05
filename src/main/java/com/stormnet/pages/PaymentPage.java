package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private SelenideElement paymentWithBankWire = $(".payment_module>a.bankwire");

    public PaymentWithBankWarePage clickPaymentWithBankWire(){
        paymentWithBankWire.click();
        return new PaymentWithBankWarePage();
    }
}
