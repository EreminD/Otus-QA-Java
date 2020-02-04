package com.otus.pattern;

import org.junit.Before;
import org.junit.Test;

public class DockerTest {
    private TestSteps steps;
    @Before
    public void setUp(){
        steps = new TestSteps();
    }

    @Test
    public void checkSelenoid(){
        steps.openBrowserOn("https://hub.docker.com");
        steps.search("selenoid");
        steps.checkUrlContains("q=selenoid");
        steps.checkResultListSize(26);
    }

}
