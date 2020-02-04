package com.otus.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByTestId extends By {
    private final String dataTestId;
    private final By byCssSelector;

    private ByTestId(String dataTestId) {
        this.dataTestId = dataTestId;
        String cssSelector = "[data-testid='"+dataTestId+"']";
        byCssSelector = new ByCssSelector(cssSelector);
    }

    public static By byTestId(String dataTestId){
        return new ByTestId(dataTestId);
    }

    @Override
    public String toString() {
        return "By.testId: " + byCssSelector;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return byCssSelector.findElements(context);
    }
}
