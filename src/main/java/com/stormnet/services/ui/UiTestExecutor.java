package com.stormnet.services.ui;

import com.codeborne.selenide.SelenideElement;

import com.stormnet.enums.Feature;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public interface UiTestExecutor {

  String FORMAT_NAME = "tiff";

  ShootingStrategy SHOOTING_STRATEGY = ShootingStrategies.viewportRetina(100, 0, 0, 2);

  void execute(
    final Feature feature,
     By... ignoredElements
  );

  void execute(
      final SelenideElement element,
      final Feature feature,
       By... ignoredElements
  );


  UiExecutorType getType();

  enum UiExecutorType {
    COMPARE,
    UPDATE
  }
}
