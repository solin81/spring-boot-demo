package com.fujitsu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final ApplicationArguments applicationArguments;

    @Autowired
    public CustomerService(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;
    }

    public String message() {
        String message = "Hello world! " + " App arguments: " + applicationArguments.getNonOptionArgs();
        return message;
    }

}
