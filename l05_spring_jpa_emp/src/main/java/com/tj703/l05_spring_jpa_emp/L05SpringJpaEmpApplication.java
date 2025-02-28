package com.tj703.l05_spring_jpa_emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(@PropertySource("classpath:/env.properties"))
public class L05SpringJpaEmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(L05SpringJpaEmpApplication.class, args);
    }

}
