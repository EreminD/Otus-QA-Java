package com.otus.webdriver.wait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitAndImplicitWaitTrap extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ExplicitAndImplicitWaitTrap.class);

    private long startTime;

    @Before
    public void getStartTime(){
        startTime = System.currentTimeMillis();
    }

    @After
    public void printTime(){
        long finish = System.currentTimeMillis();
        logger.info("Время выполнения теста: {} секунд", (finish - startTime)/1000);
    }

    @Test
    public void waitTrap(){
        logger.info("Ставим неявное ожидание на 20 секунд");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://stackoverflow.com/");


        By locator = By.cssSelector("#no-such-element");
        logger.info("Ждем, что в ближайшие 25 секунд появится элемент {}", locator);
        new WebDriverWait(driver, 25L)
                    .until(LoggerExpectedConditions.presenceOfElementLocated(locator));

        logger.error("Эта строка видна, если за 25 секунд был найден элемент {}", locator);
    }
}
