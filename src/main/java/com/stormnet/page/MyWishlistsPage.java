package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MyWishlistsPage extends AuthorizedPage{
  private SelenideElement myWishlist = $("tr > td:nth-child(1) > a");
  private SelenideElement wishlistDelete = $("td.wishlist_delete > a");

  public MyWishlistsPage clickMyWishlist() {
    myWishlist.click();
    return this;
  }
  public MyWishlistsPage clickWishlistDelete() {
    wishlistDelete.click();
    return this;
  }

  public MyWishlistsPage acceptAlert() {
    Alert alert = switchTo().alert();
    String text = alert.getText();
    Assertions.assertEquals(text, "Do you really want to delete this wishlist ?");
    alert.accept();
    return new MyWishlistsPage();
  }
}
