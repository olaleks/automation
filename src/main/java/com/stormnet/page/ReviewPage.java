package com.stormnet.page;

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

  public ReviewPage setCommentTitle() {
    commentTitle.sendKeys("High quality product");
    return this;
  }

  public ReviewPage setReviewContent() {
    reviewContent.sendKeys(
        "Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit." +
                "Accessorize with a straw hat and you're ready for summer!");
    return this;
  }
  public NotificationWindow clickSubmitReview(){
    submitReview.click();
    return new NotificationWindow();
  }
}
