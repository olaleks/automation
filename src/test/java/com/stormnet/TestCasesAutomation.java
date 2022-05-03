package com.stormnet;

import com.codeborne.selenide.ElementsCollection;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;

public class TestCasesAutomation {
    @Test
    public void testCaseRegistration(){
        open("http://automationpractice.com/index.php");
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
        sleep(10000);
        $("a.logout[title=\"Log me out\"]").click();

    }
    @Test
    public void testCaseOrderDress(){
        open("http://automationpractice.com/index.php");
        $(".login").click();
        $("#email").sendKeys("test54321@yopmail.com");
        $("#passwd").sendKeys("12345");
        $("#SubmitLogin").click();
        $("ul.sf-menu>li>a[title=\"Dresses\"]").hover();
        $("ul.submenu-container>li>a[title=\"Casual Dresses\"]").click();
        $$("div.product-container a.product_img_link[title=\"Printed Dress\"]").first().hover();
        $("div.button-container a.button[data-id-product=\"3\"]").click();
        $("a.btn[title=\"Proceed to checkout\"]").click();
        $("p.cart_navigation>a[title=\"Proceed to checkout\"]").click();
        $("p.cart_navigation>button[name=\"processAddress\"]").click();
        $("#cgv").click();
        $("button[name=\"processCarrier\"]").click();
        $("p.payment_module>a.bankwire").click();
        $("p.cart_navigation button.button[type=\"submit\"]").click();
        $("a.logout[title=\"Log me out\"]").click();
    }
    @Test
    public void testCaseEmailToCustomerService(){
        open("http://automationpractice.com/index.php");
        $(".login").click();
        $("#email").sendKeys("test54321@yopmail.com");
        $("#passwd").sendKeys("12345");
        $("#SubmitLogin").click();
        $("ul.sf-menu>li>a[title=\"Dresses\"]").hover();
        $("ul.submenu-container>li>a[title=\"Casual Dresses\"]").click();
        $$("div.product-container a.product_img_link[title=\"Printed Dress\"]").first().hover();
        $("div.button-container a.button[data-id-product=\"3\"]").click();
        $("a.btn[title=\"Proceed to checkout\"]").click();
        $("p.cart_navigation>a[title=\"Proceed to checkout\"]").click();
        $("p.cart_navigation>button[name=\"processAddress\"]").click();
        $("#cgv").click();
        $("button[name=\"processCarrier\"]").click();
        $("p.payment_module>a.bankwire").click();
        $("p.cart_navigation button.button[type=\"submit\"]").click();

        String text = $("div.box").getText();
        Pattern orderNumberPattern = Pattern.compile("[A-Z]{9}");
        Matcher matcher = orderNumberPattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        String orderNumber = matcher.group(0);

        $("a[title=\"Contact us\"]").click();
        $("#id_contact").selectOptionByValue("2");
        $("#uniform-id_contact").click();
        $("div.selector [name=\"id_order\"]").selectOptionContainingText(orderNumber);
        String orderId = $("div.selector [name=\"id_order\"]").getValue();
        $("select[name=\"id_product\"][id=\""+ orderId+ "_order_products\"]").selectOption(1);
        $("#message").sendKeys("I have a problem with my order. Could you help me?");
        $("#submitMessage").click();
        $("a.logout[title=\"Log me out\"]").click();
        sleep(20000);
    }
    @Test
    public void testCaseToWriteReview(){
        open("http://automationpractice.com/index.php");
        $(".login").click();
        $("#email").sendKeys("test54321@yopmail.com");
        $("#passwd").sendKeys("12345");
        $("#SubmitLogin").click();
        $("ul.sf-menu>li>a[title=\"T-shirts\"]").click();
        $("li.ajax_block_product").hover();
        $("a[title=\"View\"]").click();
        $("li a.open-comment-form").click();
        $("div.star>a[title=\"5\"]").hover().click();
        $("#comment_title").sendKeys("High quality product");
        $("#content")
        .sendKeys(
            "Faded short sleeve t-shirt with high neckline. Soft and stretchy material" +
                    " for a comfortable fit. Accessorize with a straw hat and you're ready for summer!");
        $("#submitNewMessage").click();
        $("div.fancybox-inner>p.submit>button[type=\"submit\"]").click();
        $("a.logout[title=\"Log me out\"]").click();
    }
}
