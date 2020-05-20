package com.otus.pattern.proxy;

import com.otus.webdriver.configuration.DriverNames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class WebDriverLogger implements WebDriver {
    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(WebDriverLogger.class);

    public WebDriverLogger() {
        this.driver = new ChromeDriver();
    }

    public void get(String var1) {
        logger.info("Go to {}", var1);
        driver.get(var1);
    }

    public List<WebElement> findElements(By var1) {
        List<WebElement> items = driver.findElements(var1);
        logger.info("Selector {}. Found {} elements", var1.toString(), items.size());
        return items;
    }

    public WebElement findElement(By var1) {
        return driver.findElements(var1).get(0);
    }
    @Override
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("URL: {}", url);
        return url;
    }

    @Override
    public String getTitle() {
        return null;
    }


    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {
driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
