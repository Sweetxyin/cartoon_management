package com.example.cartoon_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.cartoon_management.dao")
@SpringBootApplication
public class CartoonManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartoonManagementApplication.class, args);
    }

}
