package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentWithBankWarePage {
    private SelenideElement confirmOrderBtn = $(".cart_navigation button.button[type=\"submit\"]");

    public ConfirmedOrderPage clickConfirmOrder(){
        confirmOrderBtn.click();
        return new ConfirmedOrderPage();
    }
}
