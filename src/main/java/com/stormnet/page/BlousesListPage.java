package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BlousesListPage {
    private SelenideElement blousesCollection = $(".ajax_block_product");
    private SelenideElement viewButton = $(".button-container>a[title=\"View\"]");

    public BlousesListPage hoverBlouse(){
        blousesCollection.hover();
        return this;
    }
    public BlousePage clickViewButton(){
        viewButton.click();
        return new BlousePage();
    }
}
