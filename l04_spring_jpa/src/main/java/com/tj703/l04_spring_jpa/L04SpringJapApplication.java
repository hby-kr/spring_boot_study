package com.tj703.l04_spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(@PropertySource("classpath:/env.properties"))
public class L04SpringJapApplication {

    public static void main(String[] args) {
        SpringApplication.run(L04SpringJapApplication.class, args);
    }

}
