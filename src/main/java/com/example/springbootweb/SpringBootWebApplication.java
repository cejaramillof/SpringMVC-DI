package com.example.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    // to compile app use mvn package and he return jar in target and run java-jar ./target/appname.jar
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
