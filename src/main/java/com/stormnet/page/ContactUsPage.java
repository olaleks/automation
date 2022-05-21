package com.stormnet.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage extends AuthorizedPage {
    private SelenideElement subjectHeading = $("#id_contact");
    private SelenideElement selectorOrderNumber = $(".selector [name=\"id_order\"]");
    private SelenideElement orderIdSelector = $(".selector [name=\"id_order\"]");

    public ContactUsPage selectSubjectHeading(){
        subjectHeading.selectOptionByValue("2");
        return this;
    }

    public ContactUsPage selectOrderNumber(String orderNum){
        selectorOrderNumber.selectOptionContainingText(orderNum);
        return this;
    }

    public ContactUsPage selectOrderItem(){
        $("select[name=\"id_product\"][id=\"" + getOrderId() + "_order_products\"]").selectOption(1);
        return this;

    }
    public String getOrderId(){
        return orderIdSelector.getValue();
    }




}
