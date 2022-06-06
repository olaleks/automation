package com.stormnet;

import com.stormnet.base.BaseTest;
import com.stormnet.pages.*;
import com.stormnet.enums.Feature;
import com.stormnet.services.ui.ScreenshotService;
import com.stormnet.utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class TestCasesAutomation extends BaseTest {

  @Test
  public void registration() {
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
        .clickConfirmOrder();
    ConfirmedOrderPage confirmedOrderPage = new ConfirmedOrderPage();
    Assertions.assertEquals(
        "Your order on My Store is complete.", confirmedOrderPage.getConfirmedOrderText());
    confirmedOrderPage.clickSighOutButton();
  }

  @Test
  public void emailToCustomerService() {
    ConfirmedOrderPage confirmedOrderPage =
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
            .clickConfirmOrder();
    String orderNumber = confirmedOrderPage.getOrderNumber();
    confirmedOrderPage
        .clickContactUs()
        .selectSubjectHeading()
        .selectOrderNumber(orderNumber)
        .selectOrderItem()
        .setMessageText("I have a problem with my order. Could you help me")
        .sendMessage();
    ContactUsPage contactUsPage = new ContactUsPage();
    Assertions.assertEquals(
        "Your message has been successfully sent to our team.",
        contactUsPage.getSystemMessageText());
    ContactUsSuccessfulPage contactUsSuccessfulPage = new ContactUsSuccessfulPage();
    contactUsSuccessfulPage.clickSighOutButton();
  }

  @Test
  public void writeNewReview() {
    homePage
        .clickSignInButton()
        .login("test54321@yopmail.com", "12345")
        .clickTshirtMenu()
        .hoverTshirt()
        .clickViewButton()
        .clickWriteReview()
        .setStarMark()
        .setCommentTitle("High quality product")
        .setReviewContent(
            "Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit. "
                + "Accessorize with a straw hat and you're ready for summer!")
        .clickSubmitReview();
    NotificationWindow notificationWindow = new NotificationWindow();
    Assertions.assertEquals(
        "Your comment has been added and will be available once approved by a moderator",
        notificationWindow.getConfText());
    notificationWindow.clickSubmitBtn().clickSighOutButton();
  }

  @Test
  public void addItemToWishList() {
    MyWishlistsPage myWishlistsPage =
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
            .clickMyWishlist();
    Assertions.assertEquals("1", myWishlistsPage.getQuantity());
    myWishlistsPage.clickWishlistDelete().acceptAlert().clickSighOutButton();
  }

  @Owner("Olga Salachyonok")
  @DisplayName("Display different colours of Summer Printed Dress")
  @Test
  @Description(
      "We choose the colors of the dress in the sequence of 4 different colors of the calorie-box black-orange-blue-yellow")
  public void displayDifferentColoursOfSummerPrintedDress() {
    SummerDressPage summerDressPage =
        homePage
            .clickSignInButton()
            .login("test54321@yopmail.com", "12345")
            .hoverDressingMenu()
            .clickDressingMenu()
            .clickSummerDressesSubMenu()
            .hoverFirstSummerDress()
            .clickViewButton();
    Assertions.assertEquals(
        "http://automationpractice.com/img/p/1/5/15-large_default.jpg",
        summerDressPage.clickBlackColor().getMainImageSrc());
    Assertions.assertEquals(
        "http://automationpractice.com/img/p/1/4/14-large_default.jpg",
        summerDressPage.clickOrangeColor().getMainImageSrc());
    Assertions.assertEquals(
        "http://automationpractice.com/img/p/1/3/13-large_default.jpg",
        summerDressPage.clickBlueColor().getMainImageSrc());
    Assertions.assertEquals(
        "http://automationpractice.com/img/p/1/2/12-large_default.jpg",
        summerDressPage.clickYellowColor().getMainImageSrc());
    summerDressPage.clickSighOutButton();
  }
//  @Test
//  public void checkMainPageViaScreenshot(){
//    ScreenshotService.uiExecutor($("#header"), Feature.HEADER);
//    ScreenshotService.uiExecutor($("#slider_row"), Feature.SLIDER_ROW);
//    ScreenshotService.uiExecutor($("#page > .footer-container"), Feature.FOOTER);
//  }
}
