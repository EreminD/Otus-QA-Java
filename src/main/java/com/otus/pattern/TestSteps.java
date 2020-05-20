package com.otus.pattern;

import com.otus.pattern.proxy.WebDriverLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.otus.pattern.ByTestId.byTestId;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSteps {
    private WebDriver driver;

    void checkResultListSize(int i) {
        int imagesOnPage = driver.findElements(byTestId("imageSearchResult")).size();
        assertThat("На странице меньше 26 результатов", imagesOnPage, equalTo(26));
    }

    void search(String searchTerm) {
        driver.findElement(By.cssSelector("[data-testid='autocompleteInput']"))
                .sendKeys(searchTerm, Keys.RETURN);
    }

    void openBrowserOn(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new WebDriverLogger();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(url);
    }

    void checkUrlContains(String s) {
        String title = driver.getCurrentUrl();
        assertThat("title не содержит 'selenoid'", title, containsString(s));
    }

}
