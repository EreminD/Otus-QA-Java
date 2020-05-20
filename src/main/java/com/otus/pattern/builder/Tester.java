package com.otus.pattern.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class Tester {

    private final Logger logger = LogManager.getLogger(Tester.class);

    private User user;

    @Before
    public void setUp(){
        user = new UserBuilder()
                .setCity("Moscow")
                .setState("MO")
                .setStreetAddress("Lenina")
                .build();
      }

    @Test
    public void test(){
        logger.info(user);
    }
}
