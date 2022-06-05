package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userEmail = $("#email");
    private SelenideElement userPassword = $("#passwd");
    private SelenideElement submitLogin = $("#SubmitLogin");
    private SelenideElement emailCreate = $("#email_create");
    private SelenideElement submitEmail = $("#SubmitCreate");

    public AccountPage login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitLogin.click();
        return new AccountPage();
    }
    public AccountCreatePage createAccount(String email){
        emailCreate.sendKeys(email);
        submitEmail.click();
        return new AccountCreatePage();
    }

}
