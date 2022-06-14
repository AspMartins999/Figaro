package com.triagem.Figaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FigaroApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(FigaroApplication.class, args);

		SeleniumRepositorio login = new SeleniumRepositorio();



			int usuario=1;
			login.login(usuario);




	}

}