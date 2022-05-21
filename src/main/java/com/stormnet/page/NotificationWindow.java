package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NotificationWindow {
    private SelenideElement submitBtn = $(".fancybox-inner>.submit>[type=\"submit\"]");

    public TshirtPage clickSubmitBtn(){
        submitBtn.click();
        return new TshirtPage();
    }
}
