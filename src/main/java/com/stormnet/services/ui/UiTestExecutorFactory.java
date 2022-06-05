package com.stormnet.services.ui;

import com.stormnet.services.ui.UiTestExecutor.UiExecutorType;

import java.util.Optional;



public class UiTestExecutorFactory {

  private static final String UI_TEST_MODE = "ui.test.mode";

  private static final UiTestExecutorFactory INSTANCE = new UiTestExecutorFactory();

  public UiTestExecutor get() {
    final UiExecutorType type = Optional.of(UI_TEST_MODE)
        .map(System::getProperty)
        .map(UiExecutorType::valueOf)
        .orElse(UiExecutorType.COMPARE);
    return get(type);
  }

  public UiTestExecutor get(final UiExecutorType type) {
    if (type == UiExecutorType.COMPARE) {
      return new CompareUiExecutor();
    } else if (type == UiExecutorType.UPDATE) {
      return new UpdateExpectedScreenshotExecutor();
    }

    throw new IllegalArgumentException(type + " does not exist");
  }

  public static UiTestExecutorFactory getInstance() {
    return INSTANCE;
  }
}
