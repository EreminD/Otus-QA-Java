package com.otus.pattern.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tester2 {

    private List<Notifier> notifier = new ArrayList<>();

    @Before
    public void setUp(){
        notifier.add(new NotifierEmail());
        notifier.add(new NotifierSms());
        notifier.add(new NotifierSlack());
    }

    @After
    public void sendNotification(){
        notifier.forEach(n -> n.notify("Finished"));
    }

    @Test
    public void test(){
       assertThat(1, equalTo(1));
    }

}
