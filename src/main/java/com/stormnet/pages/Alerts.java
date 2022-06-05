package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Alerts {
    private SelenideElement alertWindow = $(".fancybox-error");
    private SelenideElement closeBtn = $("[title=\"Close\"]");

    public Alerts shouldHaveAlertWindow(){
        alertWindow.shouldHave(Condition.visible);
        return this;
    }
    public BlousePage clickCloseBtn(){
        closeBtn.click();
        return new BlousePage();
    }
}
