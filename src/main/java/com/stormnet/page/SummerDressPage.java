package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class SummerDressPage extends AuthorizedPage {
    private SelenideElement blackColor = $("#color_11[title =\"Black\"]");
    private SelenideElement orangeColor = $("#color_13[title =\"Orange\"]");
    private SelenideElement blueColor = $("#color_14[title =\"Blue\"]");
    private SelenideElement yellowColor = $("#color_16[title =\"Yellow\"]");
    private SelenideElement mainImage = $("#bigpic");

    public SummerDressPage clickBlackColor(){
        blackColor.click();
        return this;
    }
    public SummerDressPage clickOrangeColor(){
        orangeColor.click();
        return this;
    }
    public SummerDressPage clickBlueColor(){
        blueColor.click();
        return this;
    }
    public SummerDressPage clickYellowColor(){
        yellowColor.click();
        return this;
    }

    public String getMainImageSrc() {
        return mainImage.getAttribute("src");
    }
}
