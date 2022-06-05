package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage extends AuthorizedPage {
    private SelenideElement subjectHeading = $("#id_contact");
    private SelenideElement orderIdSelector = $(".selector [name=\"id_order\"]");
    private SelenideElement confirmation = $("#center_column > p");
    private SelenideElement messageTxt = $("#message");
    private SelenideElement clickSubmitBtn = $("#submitMessage > span");
    private String orderItem= "select[name=\"id_product\"][id=\"%s_order_products\"]";

    public ContactUsPage selectSubjectHeading(){
        subjectHeading.selectOptionByValue("2");
        return this;
    }

    public ContactUsPage selectOrderNumber(String orderNum){
        orderIdSelector.selectOptionContainingText(orderNum);
        return this;
    }

    public ContactUsPage selectOrderItem(){
        $(String.format(orderItem, getOrderId())).selectOption(1);
        return this;
    }
    public String getOrderId(){
        return orderIdSelector.getValue();
    }

    public ContactUsPage setMessageText(String messageText){
        messageTxt.sendKeys(messageText);
        return this;
    }
    public ContactUsPage sendMessage(){
        clickSubmitBtn.click();
        return this;
    }
    public String getSystemMessageText(){
        return confirmation.getText();
    }

}
