package com.clientes.carrito.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudCilentesCarritoApplication {

	public static void main(String[] args) {
		 System.setProperty("server.servlet.context-path", "/miempresa/compras/");
		SpringApplication.run(CrudCilentesCarritoApplication.class, args);
	}

}
