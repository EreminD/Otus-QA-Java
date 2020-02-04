package com.otus.pattern.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotifierEmail implements Notifier {
    private static final Logger logger = LogManager.getLogger(NotifierEmail.class);
    @Override
    public void notify(String text) {
//        SMTPService.send(text, "admin@mail.ru");
        logger.info("Send {} to {}",text, "admin@mail.ru");
    }
}
