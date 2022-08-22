package com.triagem.Figaro;

import modelo.Entidade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.SeleniumRepositorio;
import controller.BancoController;
import modelo.Entidade;

import java.awt.*;

@SpringBootApplication
public class FigaroApplication {

	public static void main(String[] args) throws InterruptedException, AWTException {
		SpringApplication.run(FigaroApplication.class, args);

		//SeleniumRepositorio login = new SeleniumRepositorio();
		//int usuario = 0;
		//login.login(usuario);
		Entidade entidade = new Entidade();
		BancoController bancoController = new BancoController();
		bancoController.dadosEntidade();
		System.out.println(entidade.getNome());

	}
}