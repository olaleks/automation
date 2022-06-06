package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountCreatePage {
  private SelenideElement genderMan = $("#id_gender1");
  private SelenideElement customer_FirstName = $("#customer_firstname");
  private SelenideElement customer_LastName = $("#customer_lastname");
  private SelenideElement password = $("#passwd");
  private SelenideElement dayOfBirth = $("#days");
  private SelenideElement monthOfBirth = $("#months");
  private SelenideElement yearOfBirth = $("#years");
  private SelenideElement infoLetters = $("#uniform-newsletter");
  private SelenideElement infoOption = $("#uniform-optin");
  private SelenideElement company = $("#company");
  private SelenideElement address = $("#address1");
  private SelenideElement city = $("#city");
  private SelenideElement stateID = $("#id_state");
  private SelenideElement postCode = $("#postcode");
  private SelenideElement idCountry = $("#id_country");
  private SelenideElement otherInfo = $("#other");
  private SelenideElement phone = $("#phone");
  private SelenideElement mobilePhone = $("#phone_mobile");
  private SelenideElement aliasAddress = $("#alias");
  private SelenideElement submitting = $("#submitAccount");

  public AccountPage createAccount(
      String firstName,
      String lastName,
      String psswrd,
      String dayOB,
      String monthOB,
      String yearOB,
      String nameOfCompany,
      String residenceAddress,
      String cityName,
      String stID,
      String zipCode,
      String countryID,
      String addInfo,
      String customerPhone,
      String customerMobilePhone,
      String alAddress) {
    genderMan.click();
    customer_FirstName.sendKeys(firstName);
    customer_LastName.sendKeys(lastName);
    password.sendKeys(psswrd);
    dayOfBirth.selectOptionByValue(dayOB);
    monthOfBirth.selectOptionByValue(monthOB);
    yearOfBirth.selectOptionByValue(yearOB);
    infoLetters.click();
    infoOption.click();
    company.sendKeys(nameOfCompany);
    address.sendKeys(residenceAddress);
    city.sendKeys(cityName);
    stateID.selectOptionByValue(stID);
    postCode.sendKeys(zipCode);
    idCountry.selectOptionByValue(countryID);
    otherInfo.sendKeys(addInfo);
    phone.sendKeys(customerPhone);
    mobilePhone.sendKeys(customerMobilePhone);
    aliasAddress.sendKeys(alAddress);
    submitting.click();
    return new AccountPage();
  }
}
