package com.sample.transactionapp.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return (args) -> {
            Arrays.stream(applicationContext.getBeanDefinitionNames())
                    .sorted()
                    .forEach(System.out::println);

        };
    }
}
