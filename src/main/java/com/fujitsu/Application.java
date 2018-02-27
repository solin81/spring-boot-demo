package com.fujitsu;

import jdk.nashorn.internal.runtime.regexp.joni.ApplyCaseFoldArg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication
public class Application implements ApplicationRunner, CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        // 1 - start app directly
        SpringApplication.run(Application.class, args);

        // 2 - start by using builder interface
/*
        new SpringApplicationBuilder()
                .sources(Application.class)
                .listeners(new LocalAppListerner())
                .bannerMode(Banner.Mode.OFF)
                .run(args);
*/
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info("Greetings from run(ApplicationArguments) method from interface ApplicationRunner");
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Greetings from run(String...) method from interface CommandLineRunner");
    }

    static class LocalAppListerner implements ApplicationListener {

        @Override
        public void onApplicationEvent(ApplicationEvent applicationEvent) {
            System.out.println(applicationEvent.toString());
        }
    }

}