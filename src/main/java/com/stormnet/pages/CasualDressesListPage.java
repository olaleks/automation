package com.stormnet.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CasualDressesListPage {
    private ElementsCollection casualDressCollection = $$(".product-container a.product_img_link[title=\"Printed Dress\"]");
    private SelenideElement casualDressAddToCartBtn = $(".button-container a.button[data-id-product=\"3\"]");
    private SelenideElement proceedToCheckoutBtn = $(".btn[title=\"Proceed to checkout\"]");

    public CasualDressesListPage hoverFirstDress() {
        casualDressCollection.first().hover();
        return this;
    }

    public CasualDressesListPage clickAddToCartBtn() {
        casualDressAddToCartBtn.click();
        return this;
    }

    public CartPage clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
        return new CartPage();
    }
}
