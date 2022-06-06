package com.stormnet.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReviewPage {
  private SelenideElement starsMark = $("div.star>a[title=\"5\"]");
  private SelenideElement commentTitle = $("#comment_title");
  private SelenideElement reviewContent = $("#content");
  private SelenideElement submitReview = $("#submitNewMessage");

  public ReviewPage setStarMark() {
    starsMark.hover().click();
    return this;
  }

  public ReviewPage setCommentTitle(String commentText) {
    commentTitle.sendKeys(commentText);
    return this;
  }

  public ReviewPage setReviewContent(String reviewText) {
    reviewContent.sendKeys(
        reviewText);
    return this;
  }
  public NotificationWindow clickSubmitReview(){
    submitReview.click();
    return new NotificationWindow();
  }
}
