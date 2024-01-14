package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {

		for(int i = 0; i <= 10; i++){
			if(i % 2 == 0){
				System.out.println("i numeri pari: " + i);
			}
			else {
				System.out.println("i numeri dispari: " + i);
			}

		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
