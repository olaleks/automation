package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NotificationWindow {
    private SelenideElement submitBtn = $(".fancybox-inner>.submit>[type=\"submit\"]");
    private SelenideElement confText = $(" .fancybox-wrap > div > div > div > p:nth-child(2)");

    public TshirtPage clickSubmitBtn(){
        submitBtn.click();
        return new TshirtPage();
    }
    public String getConfText(){
        return confText.getText();
    }
}
