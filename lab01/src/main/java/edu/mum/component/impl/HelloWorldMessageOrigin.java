package edu.mum.component.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import edu.mum.component.MessageOrigin;

@Component
public class HelloWorldMessageOrigin implements MessageOrigin {


    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage() {
        return messageSource.getMessage("messageText", null, Locale.getDefault());
    }
}