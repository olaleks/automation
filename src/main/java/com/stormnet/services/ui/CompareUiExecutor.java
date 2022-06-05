package com.stormnet.services.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import com.stormnet.enums.Feature;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import static com.codeborne.selenide.Browsers.CHROME;
import static io.qameta.allure.Allure.addAttachment;

@Slf4j
public class CompareUiExecutor implements UiTestExecutor {

  private static final String BROWSER = CHROME;
  private static final String TARGET = "target/";


  @Override
  @Step("Take a screenshot on {feature}")
  public void execute(
      final Feature feature,
      final By... ignoredElements
  ) {
    try {
      final Set<By> elements = Arrays.stream(ignoredElements).collect(Collectors.toSet());
      final Screenshot actualScreenshot = new AShot()
          .coordsProvider(new WebDriverCoordsProvider())
          .ignoredElements(elements)
          .shootingStrategy(SHOOTING_STRATEGY)
          .takeScreenshot(WebDriverRunner.getWebDriver());
      final Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(feature.getExpectedUiScreenshot())));
      // Exclude ignored coordinates from expected because it m ust have the similar coordinates
      expectedScreenshot.setIgnoredAreas(actualScreenshot.getIgnoredAreas());
      final ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
      if (diff.getDiffSize() != 0) {
        reportDiff(feature, diff, actualScreenshot, expectedScreenshot);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  @Step("Take a screenshot on {feature}")
  public void execute(
      final SelenideElement element,
      final Feature feature,
      final By... ignoredElements
  ) {
    try {
      final Set<By> elements = Arrays.stream(ignoredElements).collect(Collectors.toSet());
      final Screenshot actualScreenshot = new AShot()
          .coordsProvider(new WebDriverCoordsProvider())
          .ignoredElements(elements)
          .shootingStrategy(SHOOTING_STRATEGY)
          .takeScreenshot(WebDriverRunner.getWebDriver(), element);
      final Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(feature.getExpectedUiScreenshot())));
      // Exclude ignored coordinates from expected because it must have the similar coordinates
      expectedScreenshot.setIgnoredAreas(actualScreenshot.getIgnoredAreas());
      final ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
      if (diff.getDiffSize() != 0) {
        reportDiff(feature, diff, actualScreenshot, expectedScreenshot);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public UiExecutorType getType() {
    return UiExecutorType.COMPARE;
  }

  private void reportDiff(
      final Feature feature,
      final ImageDiff diff,
      final Screenshot actualScreenshot,
      final Screenshot expectedScreenshot
  ) throws IOException {
    final String baseName = BROWSER + "_" + feature.name().toLowerCase();
    final String diffImageName = baseName + "_diff_" + LocalDateTime.now();
    final String actualImageName = baseName + "_actual_" + LocalDateTime.now();
    final String expectedImageName = baseName + "_expected_" + LocalDateTime.now();
    if (true) {
      ImageIO.write(diff.getMarkedImage(), FORMAT_NAME, new File(TARGET + diffImageName + "." + FORMAT_NAME));
      ImageIO.write(actualScreenshot.getImage(), FORMAT_NAME, new File(TARGET + actualImageName + "." + FORMAT_NAME));
      ImageIO.write(
          expectedScreenshot.getImage(), FORMAT_NAME, new File(TARGET + expectedImageName + "." + FORMAT_NAME));
    } else {
      try (
          final ByteArrayOutputStream diffOs = new ByteArrayOutputStream();
          final ByteArrayOutputStream actualOs = new ByteArrayOutputStream();
          final ByteArrayOutputStream expectedOs = new ByteArrayOutputStream()
      ) {
        ImageIO.write(diff.getMarkedImage(), FORMAT_NAME, diffOs);
        ImageIO.write(actualScreenshot.getImage(), FORMAT_NAME, actualOs);
        ImageIO.write(expectedScreenshot.getImage(), FORMAT_NAME, expectedOs);

        addAttachment(diffImageName, new ByteArrayInputStream(diffOs.toByteArray()));
        addAttachment(actualImageName, new ByteArrayInputStream(actualOs.toByteArray()));
        addAttachment(expectedImageName, new ByteArrayInputStream(expectedOs.toByteArray()));
      }
    }
    throw new RuntimeException("There are some bugs on the page");
  }
}
