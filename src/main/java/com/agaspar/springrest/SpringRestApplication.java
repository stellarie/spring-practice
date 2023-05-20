package com.agaspar.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);

		try {
			start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void start() {
		System.out.println("service started");
	}
}
