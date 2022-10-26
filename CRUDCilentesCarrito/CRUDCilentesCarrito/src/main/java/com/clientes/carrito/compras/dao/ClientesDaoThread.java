package com.clientes.carrito.compras.dao;

public class ClientesDaoThread implements Runnable  {

	public ClientesDaoThread() {
		
	}
	public void run() {
		
		try {
			Thread.sleep(8000);
			ClientesDao dao= new ClientesDao();
			dao.resgistroExitoso();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
