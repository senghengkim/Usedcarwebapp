package com.example.usedcars;

import javax.swing.Spring;

import org.springframework.beans.factory.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.usedcars.car.Car;
import com.example.usedcars.car.Status;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner carInitializerRunner(){
		return args -> {
			Car car = new Car(1, "Toyota", "Camry", 2018, "White", 30000, "1HGCM82633A123456", Status.AVAILABLE);
			log.info("Car: {}", car);
			};
		}

}
 