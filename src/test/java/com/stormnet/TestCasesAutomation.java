package com.stormnet;

import com.codeborne.selenide.Configuration;

import com.stormnet.base.BaseTest;
import com.stormnet.page.ConfirmedOrderPage;
import com.stormnet.page.HomePage;
import com.stormnet.utils.Utils;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestCasesAutomation extends BaseTest {

  @Test
  public void registration() {
    HomePage homePage = open("/", HomePage.class);
    homePage
        .clickSignInButton()
        .createAccount(Utils.randomEmail())
        .createAccount(
            "Ivan",
            "Ivanov",
            "12345",
            "1",
            "1",
            "2002",
            "Kaseya",
            "701 Brickell Avenue",
            "Miami",
            "9",
            "33131",
            "21",
            "Additional Information",
            "+375292929297",
            "+375333333333",
            "18, Baker street")
            .clickSighOutButton();
  }

  @Test
  public void orderPrintedDressTest() {
    HomePage homePage = open("/", HomePage.class);
    homePage
            .clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .hoverDressingMenu()
            .clickCasualDresses()
            .hoverFirstDress()
            .clickAddToCartBtn()
            .clickProceedToCheckoutBtn()
            .clickProceedToCheckoutBtn()
            .clickProceedAddressBtn()
            .selectAgreeTermsCheckBox()
            .clickProcessCarrierBtn()
            .clickPaymentWithBankWire()
            .clickConfirmOrder()
            .clickSighOutButton();
  }
  @Test
  public void emailToCustomerService() {
    HomePage homePage = open("/", HomePage.class);
    ConfirmedOrderPage confirmedOrderPage = homePage.clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .hoverDressingMenu()
            .clickCasualDresses()
            .hoverFirstDress()
            .clickAddToCartBtn()
            .clickProceedToCheckoutBtn()
            .clickProceedToCheckoutBtn()
            .clickProceedAddressBtn()
            .selectAgreeTermsCheckBox()
            .clickProcessCarrierBtn()
            .clickPaymentWithBankWire()
            .clickConfirmOrder();
    String orderNumber = confirmedOrderPage.getOrderNumber();
    confirmedOrderPage
            .clickContactUs()
            .selectSubjectHeading()
            .selectOrderNumber(orderNumber)
            .selectOrderItem()
            .clickSighOutButton();
  }

  @Test
  public void writeNewReview() {
    HomePage homePage = open("/", HomePage.class);
    homePage
            .clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .clickTshirtMenu()
            .hoverTshirt()
            .clickViewButton()
            .clickWriteReview()
            .setStarMark()
            .setCommentTitle()
            .setReviewContent()
            .clickSubmitReview()
            .clickSubmitBtn()
            .clickSighOutButton();
  }

  @Test
  public void addItemToWishList() {
    HomePage homePage = open("/", HomePage.class);
    homePage
            .clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .hoverWomenMenu()
            .hoverTopsSubMenu()
            .clickBlousesMenu()
            .hoverBlouse()
            .clickViewButton()
            .clickWishlistButton()
            .shouldHaveAlertWindow()
            .clickCloseBtn()
            .clickAccountButton()
            .clickMyWishlistButton()
            .clickMyWishlist()
            .clickWishlistDelete()
            .acceptAlert()
            .clickSighOutButton();
  }

  @Test
  public void displayingDifferentColoursOfSummerPrintedDress() {
    HomePage homePage = open("/", HomePage.class);
    homePage
            .clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .hoverDressingMenu()
            .clickSummerDressesSubMenu()
            .hoverFirstSummerDress()
            .clickViewButton()
            .clickBlackColor()
            .clickOrangeColor()
            .clickBlueColor()
            .clickYellowColor()
            .clickSighOutButton();
  }
}
