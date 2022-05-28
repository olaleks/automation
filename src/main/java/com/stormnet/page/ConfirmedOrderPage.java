package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmedOrderPage extends AuthorizedPage {
  private SelenideElement confText = $("p .dark");
  public String getOrderNumber() {
    String text = $("div.box").getText();
    Pattern orderNumberPattern = Pattern.compile("[A-Z]{9}");
    Matcher matcher = orderNumberPattern.matcher(text);
    Assertions.assertTrue(matcher.find());
    return matcher.group(0);
  }
  public String getConfirmedOrderText(){
    return confText.getText();
  }
}
