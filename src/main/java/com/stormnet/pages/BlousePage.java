package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BlousePage extends AuthorizedPage {
    private SelenideElement wishlistButton = $("#wishlist_button");

    public Alerts clickWishlistButton(){
        wishlistButton.click();
        return new Alerts();
    }
}
