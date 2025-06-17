package com.webflux.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import reactor.blockhound.BlockHound;
import java.util.Arrays;



@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		BlockHound.builder() // <1>
				.allowBlockingCallsInside( //
						TemplateEngine.class.getCanonicalName(), "process") // <2>
				.install(); // <3>
		SpringApplication.run(TestApplication.class, args);
	}



}
