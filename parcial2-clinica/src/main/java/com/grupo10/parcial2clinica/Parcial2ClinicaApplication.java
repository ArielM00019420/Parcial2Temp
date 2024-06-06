package com.grupo10.parcial2clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })

public class Parcial2ClinicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Parcial2ClinicaApplication.class, args);
    }

}
