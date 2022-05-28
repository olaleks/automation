package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private SelenideElement proceedToCheckoutBtn = $(".cart_navigation>a[title=\"Proceed to checkout\"]");

    public VerifyAddressPage clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
        return new VerifyAddressPage();
    }
}
