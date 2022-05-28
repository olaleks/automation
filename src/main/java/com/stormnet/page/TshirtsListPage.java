package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TshirtsListPage {
    private SelenideElement tshirtsCollection = $(".ajax_block_product");
    private SelenideElement viewButton = $("[title=\"View\"]");

    public TshirtsListPage hoverTshirt(){
        tshirtsCollection.hover();
        return this;
    }
    public TshirtPage clickViewButton(){
        viewButton.click();
        return new TshirtPage();
    }
}
