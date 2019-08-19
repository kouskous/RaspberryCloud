package com.igniter.dataStorageAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.igniter.dataStorageAPI.repository")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
