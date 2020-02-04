package com.otus.pattern.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotifierSlack implements Notifier {

    private static final Logger logger = LogManager.getLogger(NotifierSlack.class);

    @Override
    public void notify(String text) {
//        SlackConnection.sendMessage(text, "otus-channel");
        logger.info("Send {} to {}",text, "admin@mail.ru");

    }
}
