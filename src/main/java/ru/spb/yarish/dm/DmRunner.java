package ru.spb.yarish.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = "ru.spb.yarish.dm")
public class DmRunner {

    public static void main(String[] args) {
        SpringApplication.run(DmRunner.class, args);
    }
}
