package com.clientes.carrito.compras.services;

import java.util.List;

import com.clientes.carrito.compras.model.Cliente;
import com.clientes.carrito.compras.model.Productos;

public interface CrudServices {

	Cliente add(Cliente c);

	Cliente update(Cliente c);

	Cliente search(int id);

	String delete(int id);

	List<Cliente> allshow();

	Cliente rmvaddproductoCliente(int idcliente, int idproducto);

	Cliente addproductoCliente(int idcliente, int  idproducto, int cantidad);
	List <Productos> showProductos();
}
