package com.sigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.sigma")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    //End Support Cache API
}
