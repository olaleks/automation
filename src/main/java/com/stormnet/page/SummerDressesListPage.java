package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SummerDressesListPage {
    private SelenideElement firstSummerDress = $(".first-in-line");
    private SelenideElement viewButton = $(".first-in-line [title=\"View\"]");

    public SummerDressesListPage hoverFirstSummerDress(){
        firstSummerDress.hover();
        return this;
    }
    public SummerDressPage clickViewButton(){
        viewButton.click();
        return new SummerDressPage();
    }
}
