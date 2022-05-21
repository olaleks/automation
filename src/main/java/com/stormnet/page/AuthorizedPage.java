package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizedPage {
    private SelenideElement accountButton = $(".account");
    private SelenideElement sighOutButton = $(".logout[title=\"Log me out\"]");
    private SelenideElement contactUs = $("a[title=\"Contact us\"]");


    public AccountPage clickAccountButton(){
        accountButton.click();
        return new AccountPage();
    }
    public void clickSighOutButton(){
        sighOutButton.click();
    }
    public ContactUsPage clickContactUs(){
        contactUs.click();
        return new ContactUsPage();
    }

}
