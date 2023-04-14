package com.elpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: Duncan MacLeod (101160585)
 *
 * Starts the Spring Program
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.elpms.model"})
@ComponentScan(basePackages = {"com.elpms.cors", "com.elpms.controller"})
public class ELPMSApplication {
	public static void main(String[] args) {SpringApplication.run(ELPMSApplication.class, args);}
}
