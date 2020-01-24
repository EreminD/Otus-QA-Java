package com.otus.webdriver.wait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggerExpectedConditions {
    private final static Logger logger = LogManager.getLogger(LoggerExpectedConditions.class);

    public static ExpectedCondition<WebElement> presenceOfElementLocated(final By locator){
        return webDriver -> {
            logger.info("Проверяем наличие элемента {}", locator.toString());
            return ExpectedConditions.presenceOfElementLocated(locator).apply(webDriver);
        };
    }

}
