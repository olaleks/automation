package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TshirtPage extends AuthorizedPage {
    private SelenideElement writeReview = $("li .open-comment-form");

    public ReviewPage clickWriteReview(){
        writeReview.click();
        return new ReviewPage();
    }
}
