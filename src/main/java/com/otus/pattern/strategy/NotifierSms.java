package com.otus.pattern.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotifierSms implements Notifier {
    private static final Logger logger = LogManager.getLogger(NotifierSms.class);

    @Override
    public void notify(String text) {
//        SMSService.sendSms(text);
        logger.info("Send {} to {}",text, "admin@mail.ru");

    }
}
