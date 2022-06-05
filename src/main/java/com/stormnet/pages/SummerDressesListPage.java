package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SummerDressesListPage {
  private SelenideElement firstSummerDress = $(".first-in-line");
  private SelenideElement viewButton = $(".first-in-line [title=\"View\"]");

  @Step("Hover over to first \"Printed Summer Dress\" with four colour")
  public SummerDressesListPage hoverFirstSummerDress() {
    firstSummerDress.hover();
    return this;
  }

  @Step("Click on \"More\" button")
  public SummerDressPage clickViewButton() {
    viewButton.click();
    return new SummerDressPage();
  }
}
