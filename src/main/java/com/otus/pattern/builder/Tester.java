package com.otus.pattern.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tester {

    private final Logger logger = LogManager.getLogger(Tester.class);

    private User user;

    @Before
    public void setUp(){
        user = User.builder().setCity("Moscow").setFirstName("Jack").build();
    }

    @Test
    public void test(){
        logger.info("User {}", user);
    }
}
