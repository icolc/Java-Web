package com.xrui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TliasSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasSystemApplication.class, args);
    }
}
