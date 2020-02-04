package com.otus.pattern;

import com.otus.webdriver.configuration.WindowHandlingTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.otus.pattern.ByTestId.byTestId;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpaghettiCode {
    private static final Logger logger = LogManager.getLogger(WindowHandlingTest.class);

    private WebDriver driver;

    @After
    public void teardown() {
        if (driver != null){
            driver.quit();
        }
    }
    @Test
    public void whatIsGoingOn(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&fg=1#?modal_active=none");
        driver.findElement(By.cssSelector("a.button.cta-main")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(drvr -> drvr.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);

        tabs.forEach(logger::info);

        String currentTab = driver.getWindowHandle();
        logger.info("Current tab: {}", currentTab);
        tabs.remove(currentTab);
        String anotherTab = tabs.get(0);
        logger.info("Another: {}", anotherTab);
        logger.info("Switch");
        driver.switchTo().defaultContent();
        driver.switchTo().window(anotherTab);

        logger.info("Current: {}", driver.getWindowHandle());
    }

    @Test
    public void anotherOneSpaghettiTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.get("https://hub.docker.com");
        driver.findElement(By.cssSelector("[data-testid='autocompleteInput']"))
                .sendKeys("selenoid", Keys.RETURN);

        String url = driver.getCurrentUrl();
        assertThat("title не содержит 'selenoid'", url, containsString("q=selenoid"));

        int imagesOnPage = driver.findElements(byTestId("imageSearchResult")).size();
        assertThat("На странице меньше 26 результатов", imagesOnPage, equalTo(26));
    }
}
