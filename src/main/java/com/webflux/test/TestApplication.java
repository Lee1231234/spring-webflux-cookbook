package com.webflux.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import reactor.blockhound.BlockHound;
import java.util.Arrays;



@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(TestApplication.class, args);
	}



}
