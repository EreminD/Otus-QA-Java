package com.otus.webdriver.action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExecuteJs {

    private static final Logger logger = LogManager.getLogger(ExecuteJs.class);

    private static final String CONSOLE_LOG = "var test = 'I am text'; console.log(test)";
    private static final String RETURN_TEXT = "return 'text'";
    private static final String RETURN_NUBER = "return 26";
    private static final String RETURN_BOOL = "return true";
    private static final String RETURN_ELEMENT = "return document.querySelector('#text')";

    private static final String RETURN_ASYNC =
            "const callback = arguments[arguments.length - 1];" +
                    "const xhr = new XMLHttpRequest();" +
                    "xhr.open('GET', '//yastatic.net/iconostasis/_/8lFaTHLDzmsEZz-5XaQg9iTWZGE.png', true);" +
                    "xhr.onreadystatechange = () => {" +
                    "  if (xhr.readyState == 4) {" +
                    "    callback(xhr.responseText);" +
                    "  }" +
                    "};" +
                    "xhr.send();";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 4);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void execute() {
        driver.get("https://ya.ru/");

        Object willBeNull = ((JavascriptExecutor) driver).executeScript(CONSOLE_LOG);
        String string = (String) ((JavascriptExecutor) driver).executeScript(RETURN_TEXT);
        Long number = (Long) ((JavascriptExecutor) driver).executeScript(RETURN_NUBER);
        Boolean bool = (Boolean) ((JavascriptExecutor) driver).executeScript(RETURN_BOOL);
        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(RETURN_ELEMENT);
    }

    @Test
    public void executeAsync() {
        driver.get("https://ya.ru/");
        Object string = ((JavascriptExecutor) driver).executeScript(RETURN_ASYNC);
        Object response = ((JavascriptExecutor) driver).executeAsyncScript(RETURN_ASYNC);
    }

    @Test
    public void findAllCars() throws InterruptedException {
        driver.get("https://www.drive2.ru/cars/audi/?sort=selling");

        while (true) {
            List<WebElement> oldElementsState = driver.findElements(By.cssSelector(".c-car-card-sa__caption"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 5000)");
            Thread.sleep(1000);
            List<WebElement> newElementsState = driver.findElements(By.cssSelector(".c-car-card-sa__caption"));
            logger.debug(newElementsState.size());
            if (newElementsState.size() == oldElementsState.size()) {
                break;
            }
        }
        List<WebElement> newElementsState = driver.findElements(By.cssSelector(".c-car-card-sa__caption"));
        logger.info("Size {}", newElementsState.size());

    }
}
