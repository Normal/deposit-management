package ru.spb.yarish.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import ru.spb.yarish.dm.config.MvcConfig;
import ru.spb.yarish.dm.config.SecurityConfig;

@SpringBootApplication
@ComponentScan(basePackages = "ru.spb.yarish.dm")
@Import({SecurityConfig.class, MvcConfig.class})
@EnableScheduling
public class DmRunner {

    public static void main(String[] args) {
        SpringApplication.run(DmRunner.class, args);
    }
}
