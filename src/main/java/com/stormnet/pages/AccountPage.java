package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends AuthorizedPage {
    private SelenideElement dressesMenu = $(".sf-menu>li>a[title=\"Dresses\"]");
    private SelenideElement casualDressesSubMenu = $(".submenu-container>li>a[title=\"Casual Dresses\"]");
    private SelenideElement tshirtsMenu = $(".sf-menu>li>[title=\"T-shirts\"]");
    private SelenideElement womenMenu = $(".sf-menu>li>[title=\"Women\"]");
    private SelenideElement topsSubMenu = $(".submenu-container>li>[title=\"Tops\"]");
    private SelenideElement blousesMenu = $("li>[title=\"Blouses\"]");
    private SelenideElement myWishlistButton = $("[title=\"My wishlists\"]");
    private SelenideElement summerDressesSubMenu = $("#subcategories > ul > li:nth-child(3)");

    @Step("Hover on \"DRESSES\" in menu line")
    public AccountPage hoverDressingMenu() {
        dressesMenu.hover();
        return this;
    }

  @Step("Click on \"DRESSES\" in menu line")
  public AccountPage clickDressingMenu() {
        dressesMenu.click();
        return this;
    }

    public CasualDressesListPage clickCasualDresses() {
        casualDressesSubMenu.click();
        return new CasualDressesListPage();
    }

    public TshirtsListPage clickTshirtMenu(){
        tshirtsMenu.click();
        return new TshirtsListPage();
    }

    public AccountPage hoverWomenMenu(){
        womenMenu.hover();
        return this;
    }
    public AccountPage hoverTopsSubMenu(){
        topsSubMenu.hover();
        return this;
    }
    public BlousesListPage clickBlousesMenu(){
        blousesMenu.click();
        return new BlousesListPage();
    }
    public MyWishlistsPage clickMyWishlistButton(){
        myWishlistButton.click();
        return new MyWishlistsPage();
    }

    @Step("Click on \"SUMMER DRESSES\" button")
    public SummerDressesListPage clickSummerDressesSubMenu(){
        summerDressesSubMenu.click();
        return new SummerDressesListPage();
    }

}
