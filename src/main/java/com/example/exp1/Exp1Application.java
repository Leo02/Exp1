package com.example.exp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Exp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exp1Application.class, args);
    }

}
