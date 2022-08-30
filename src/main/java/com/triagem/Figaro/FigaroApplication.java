package com.triagem.Figaro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.sql.*;

import repository.SeleniumRepositorio;

@SpringBootApplication
public class FigaroApplication {

	public static void main(String[] args) throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		SpringApplication.run(FigaroApplication.class, args);

		SeleniumRepositorio login = new SeleniumRepositorio();

		int usuario = 0;
		login.login(usuario);

	}

}
