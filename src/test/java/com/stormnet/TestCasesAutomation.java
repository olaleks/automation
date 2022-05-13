package com.stormnet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

public class TestCasesAutomation {
  @BeforeAll
  public static void setUp() {
    Configuration.baseUrl = "http://automationpractice.com";
    Configuration.timeout = 4005;
    Configuration.browser = "chrome";
    Configuration.browserSize = "1400x920";
    Configuration.browserPosition = "200x20";
    Configuration.headless = false;
    Configuration.savePageSource = false;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(CHROME);
    final ChromeOptions options = new ChromeOptions();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    capabilities.setCapability("enableVNC", true);
    Configuration.fastSetValue = true;
    Configuration.browserCapabilities = capabilities;
  }

  @Test
  public void registration() {
    open("/index.php");
    $(".login").click();
    $("#email_create").sendKeys(RandomStringUtils.randomAlphabetic(5) + "@yopmail.com");
    $("#SubmitCreate").click();
    $("#id_gender1").click();
    $("#customer_firstname").sendKeys("Ivan");
    $("#customer_lastname").sendKeys("Ivanov");
    $("#passwd").sendKeys("12345");
    $("#days").selectOptionByValue("1");
    $("#months").selectOptionByValue("1");
    $("#years").selectOptionByValue("2002");
    $("#uniform-newsletter").click();
    $("#uniform-optin").click();
    $("#company").sendKeys("Kaseya");
    $("#address1").sendKeys("701 Brickell Avenue");
    $("#city").sendKeys("Miami");
    $("#id_state").selectOptionByValue("9");
    $("#postcode").sendKeys("33131");
    $("#id_country").selectOptionByValue("21");
    $("#other").sendKeys("Additional Information");
    $("#phone").sendKeys("+375292929297");
    $("#phone_mobile").sendKeys("+375333333333");
    $("#alias").sendKeys("18, Baker street");
    $("#submitAccount").click();
    $(".logout[title=\"Log me out\"]").click();
  }

  @Test
  public void orderingPrintedDress() {
    open("http://automationpractice.com/index.php");
    $(".login").click();
    $("#email").sendKeys("test54321@yopmail.com");
    $("#passwd").sendKeys("12345");
    $("#SubmitLogin").click();
    $(".sf-menu>li>a[title=\"Dresses\"]").hover();
    $(".submenu-container>li>a[title=\"Casual Dresses\"]").click();
    $$(".product-container a.product_img_link[title=\"Printed Dress\"]").first().hover();
    $(".button-container a.button[data-id-product=\"3\"]").click();
    $(".btn[title=\"Proceed to checkout\"]").click();
    $(".cart_navigation>a[title=\"Proceed to checkout\"]").click();
    $(".cart_navigation>button[name=\"processAddress\"]").click();
    $("#cgv").click();
    $("button[name=\"processCarrier\"]").click();
    $(".payment_module>a.bankwire").click();
    $(".cart_navigation button.button[type=\"submit\"]").click();
    $(".logout[title=\"Log me out\"]").click();
  }

  @Test
  public void emailingToCustomerService() {
    open("http://automationpractice.com/index.php");
    $(".login").click();
    $("#email").sendKeys("test54321@yopmail.com");
    $("#passwd").sendKeys("12345");
    $("#SubmitLogin").click();
    $(".sf-menu>li>a[title=\"Dresses\"]").hover();
    $(".submenu-container>li>a[title=\"Casual Dresses\"]").click();
    $$(".product-container .product_img_link[title=\"Printed Dress\"]").first().hover();
    $(".button-container .button[data-id-product=\"3\"]").click();
    $(".btn[title=\"Proceed to checkout\"]").click();
    $(".cart_navigation>a[title=\"Proceed to checkout\"]").click();
    $(".cart_navigation>button[name=\"processAddress\"]").click();
    $("#cgv").click();
    $("button[name=\"processCarrier\"]").click();
    $(".payment_module>a.bankwire").click();
    $(".cart_navigation button.button[type=\"submit\"]").click();
    String text = $("div.box").getText();
    Pattern orderNumberPattern = Pattern.compile("[A-Z]{9}");
    Matcher matcher = orderNumberPattern.matcher(text);
    Assertions.assertTrue(matcher.find());
    String orderNumber = matcher.group(0);
    $("a[title=\"Contact us\"]").click();
    $("#id_contact").selectOptionByValue("2");
    $("#uniform-id_contact").click();
    $(".selector [name=\"id_order\"]").selectOptionContainingText(orderNumber);
    String orderId = $(".selector [name=\"id_order\"]").getValue();
    $("select[name=\"id_product\"][id=\"" + orderId + "_order_products\"]").selectOption(1);
    $("#message").sendKeys("I have a problem with my order. Could you help me?");
    $("#submitMessage").click();
    $(".logout[title=\"Log me out\"]").click();
  }

  @Test
  public void writingNewReview() {
    open("http://automationpractice.com/index.php");
    $(".login").click();
    $("#email").sendKeys("test54321@yopmail.com");
    $("#passwd").sendKeys("12345");
    $("#SubmitLogin").click();
    $(".sf-menu>li>[title=\"T-shirts\"]").click();
    $(".ajax_block_product").hover();
    $("[title=\"View\"]").click();
    $("li .open-comment-form").click();
    $("div.star>a[title=\"5\"]").hover().click();
    $("#comment_title").sendKeys("High quality product");
    $("#content")
        .sendKeys(
            "Faded short sleeve t-shirt with high neckline. Soft and stretchy material"
                + " for a comfortable fit. Accessorize with a straw hat and you're ready for summer!");
    $("#submitNewMessage").click();
    $(".fancybox-inner>.submit>[type=\"submit\"]").click();
    $(".logout[title=\"Log me out\"]").click();
  }

  @Test
  public void addingItemToWishList() {
    open("/index.php");
    $(".login").click();
    $("#email").sendKeys("test54321@yopmail.com");
    $("#passwd").sendKeys("12345");
    $("#SubmitLogin").click();
    $(".sf-menu>li>[title=\"Women\"]").hover();
    $(".submenu-container>li>[title=\"Tops\"]").hover();
    $("li>[title=\"Blouses\"]").click();
    $(".ajax_block_product").hover();
    $(".button-container>a[title=\"View\"]").click();
    $("#wishlist_button").click();
    $(".fancybox-error").shouldHave(Condition.visible);
    $("[title=\"Close\"]").click();
    $(".account").click();
    $("[title=\"My wishlists\"]").click();
    $("tr > td:nth-child(1) > a").click();
    $("td.wishlist_delete > a").click();
    Alert alert = switchTo().alert();
    String text = alert.getText();
    Assertions.assertEquals(text, "Do you really want to delete this wishlist ?");
    alert.accept();
    $(".logout[title=\"Log me out\"]").click();
  }

  @Test
  public void displayingDifferentColoursOfSummerPrintedDress() {
    open("/index.php");
    $(".login").click();
    $("#email").sendKeys("test54321@yopmail.com");
    $("#passwd").sendKeys("12345");
    $("#SubmitLogin").click();
    $(".sf-menu>li>[title=\"Dresses\"]").hover();
    $(".submenu-container>li>[title=\"Summer Dresses\"]").click();
    $(".first-in-line").hover();
    $(".first-in-line [title=\"View\"]").click();
    $("#color_11[title =\"Black\"]").click();
    $("#color_13[title =\"Orange\"]").click();
    $("#color_14[title =\"Blue\"]").click();
    $("#color_16[title =\"Yellow\"]").click();
    $(".logout[title=\"Log me out\"]").click();
  }
}
