package com.stormnet.services.ui;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.stormnet.enums.Feature;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class UpdateExpectedScreenshotExecutor implements UiTestExecutor {

  @Override
  public void execute(
    final Feature feature,
    final By... ignoredElements
  ) {
    try {
      final Screenshot actualScreenshot = new AShot()
          .coordsProvider(new WebDriverCoordsProvider())
          .shootingStrategy(SHOOTING_STRATEGY)
        .takeScreenshot(WebDriverRunner.getWebDriver());
      ImageIO.write(actualScreenshot.getImage(), FORMAT_NAME, new File(feature.getExpectedUiScreenshot()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void execute(
      final SelenideElement element,
      final Feature feature,
      final By... ignoredElements
  ) {
    try {
      final Screenshot actualScreenshot = new AShot()
          .shootingStrategy(SHOOTING_STRATEGY)
          .coordsProvider(new WebDriverCoordsProvider())
          .takeScreenshot(WebDriverRunner.getWebDriver(), element);
      ImageIO.write(actualScreenshot.getImage(), FORMAT_NAME, new File(feature.getExpectedUiScreenshot()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public UiExecutorType getType() {
    return UiExecutorType.UPDATE;
  }
}
