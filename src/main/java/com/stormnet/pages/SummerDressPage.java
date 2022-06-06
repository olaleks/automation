package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SummerDressPage extends AuthorizedPage {
    private SelenideElement blackColor = $("#color_11[title =\"Black\"]");
    private SelenideElement orangeColor = $("#color_13[title =\"Orange\"]");
    private SelenideElement blueColor = $("#color_14[title =\"Blue\"]");
    private SelenideElement yellowColor = $("#color_16[title =\"Yellow\"]");
    private SelenideElement mainImage = $("#bigpic");

  @Step("Click on \"Black\" color")
  public SummerDressPage clickBlackColor() {
        blackColor.click();
        return this;
    }

    @Step("Click on \"Orange\" colour")
    public SummerDressPage clickOrangeColor(){
        orangeColor.click();
        return this;
    }

    @Step("Click on \"Blue\" colour")
    public SummerDressPage clickBlueColor(){
        blueColor.click();
        return this;
    }

    @Step("Click on \"Yellow\" colour")
    public SummerDressPage clickYellowColor(){
        yellowColor.click();
        return this;
    }

    public String getMainImageSrc() {
        return mainImage.getAttribute("src");
    }
}
