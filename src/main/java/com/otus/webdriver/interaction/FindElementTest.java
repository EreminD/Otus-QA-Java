package com.otus.webdriver.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(FindElementTest.class);

    //session/{session id}/element/{element id}/element
    @Test
    public void findElements() {
        driver.get("https://hh.ru/search/vacancy?area=1&st=searchVacancy&text=qa+java");
        WebElement searchContainer = driver.findElement(By.cssSelector(".sticky-container"));
        logger.info("WebElement extends SearchContext");
        logger.info("WebDriver -> Let start node be the current browsing context’s document element.");
        logger.info("WebElement -> Let start node be the result of trying to get a known connected element with url variable element id.");

        List<WebElement> results = searchContainer.findElements(By.cssSelector(".vacancy-serp-item"));
        logger.info("Count results: {}", results.size());
    }

    @Test
    public void otusTest(){
        driver.get("https://otus.ru/");

        WebElement form = driver.findElement(By.cssSelector("form.new-log-reg__form.js-login"));
        form.findElement(By.cssSelector("input[name=email]")).sendKeys("a@mai.ru");
        form.findElement(By.cssSelector("input[type=password]")).sendKeys("");
        form.submit();

        driver.get("https://otus.ru/lk/biography/personal/");
    }
}

