package com.triagem.Figaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.SeleniumRepositorio;

import java.awt.*;

@SpringBootApplication
public class FigaroApplication {

	public static void main(String[] args) throws InterruptedException, AWTException {
		SpringApplication.run(FigaroApplication.class, args);

		SeleniumRepositorio login = new SeleniumRepositorio();

		int usuario = 0;
		login.login(usuario);
	}
}