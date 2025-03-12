package com.example.tennis;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan
public class TennisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisApplication.class, args);

        new Play().simulation();
	}
}
