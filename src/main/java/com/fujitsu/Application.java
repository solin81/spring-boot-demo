package com.fujitsu;

import jdk.nashorn.internal.runtime.regexp.joni.ApplyCaseFoldArg;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        // 1
//        SpringApplication.run(Application.class, args);

        // 2
        new SpringApplicationBuilder()
                .sources(Application.class)
                .listeners(new LocalAppListerner())
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    static class LocalAppListerner implements ApplicationListener {

        @Override
        public void onApplicationEvent(ApplicationEvent applicationEvent) {
            System.out.println(applicationEvent.toString());
        }
    }

}