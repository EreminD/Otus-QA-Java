package com.otus.webdriver.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CookieTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CookieTest.class);

    @Test
    public void getCookies() {
        createDriver();
        open("https://otus.ru/");
        login();

        Cookie session = driver.manage().getCookieNamed("sessionid");
        driver.quit();

        openAsAuth(session.getValue());
    }

    public void openAsAuth(String sessionid) {
        createDriver();
        open("https://otus.ru/");

        Cookie c = new Cookie("sessionid", sessionid);
        driver.manage().addCookie(c);

        open("https://otus.ru");
    }

    private void createDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void open(String url) {
        driver.get(url);
        logger.info("Title: {}", driver.getTitle());
    }

    private void login() {
        logger.info("Login with credentials");
        driver.findElement(By.cssSelector(".header2__auth-reg")).click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("form.js-login input[name=email]")).sendKeys("dmitry.eremin@inbox.ru");
        driver.findElement(By.cssSelector("form.js-login input[name=password]")).sendKeys(PASS);
        driver.findElement(By.cssSelector("form.js-login button[type=submit]")).click();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





















    public static final String PASS = "wrong";
}

