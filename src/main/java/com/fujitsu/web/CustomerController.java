package com.fujitsu.web;

import com.fujitsu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService service;
    private final Environment environment;

    @Autowired
    public CustomerController(CustomerService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @RequestMapping("/")
    public String home() {
        return service.message();
    }

    @RequestMapping("/commandlinevalue")
    public String commandLineValue() {
        String command_line_value = environment.getProperty("command_line_value");
        return command_line_value;
    }

    @RequestMapping("/randomvalues")
    public String randomValues() {
        String property = environment.getProperty("my.secret");
        return property;
    }

}
