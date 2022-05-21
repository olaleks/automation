package com.stormnet.page;

import org.junit.jupiter.api.Assertions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmedOrderPage extends AuthorizedPage {
  public String getOrderNumber() {
    String text = $("div.box").getText();
    Pattern orderNumberPattern = Pattern.compile("[A-Z]{9}");
    Matcher matcher = orderNumberPattern.matcher(text);
    Assertions.assertTrue(matcher.find());
    return matcher.group(0);
  }
}
