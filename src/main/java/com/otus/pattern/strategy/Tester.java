package com.otus.pattern.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tester {

    private Notifier notifier;

    @Before
    public void setUp(){
        notifier = new NotifierEmail();
    }

    @After
    public void sendNotification(){
        notifier.notify("Finished");
    }

    @Test
    public void test(){
       assertThat(1, equalTo(1));
    }

}
