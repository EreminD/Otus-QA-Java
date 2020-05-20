package com.otus.pattern.strategy;

import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tester {

    private Notifier notifier;

    public Tester(Notifier notifier) {
        this.notifier = notifier;
    }

    @After
    public void sendNotification(){
        notifier.notify("hello");
    }

    @Test
    public void test(){
       assertThat(1, equalTo(1));
    }

}
