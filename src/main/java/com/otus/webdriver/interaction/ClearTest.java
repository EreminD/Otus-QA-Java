package com.otus.webdriver.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClearTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ClearTest.class);

    ///session/{session id}/element/{element id}/clear
    @Test
    public void clear() {
        driver.get("https://account.habr.com/login/");
        WebElement element = driver.findElement(By.cssSelector("#email_field"));

        element.sendKeys("test@otus.ru");
        driver.findElement(By.cssSelector("#email_field")).clear();
    }
}

