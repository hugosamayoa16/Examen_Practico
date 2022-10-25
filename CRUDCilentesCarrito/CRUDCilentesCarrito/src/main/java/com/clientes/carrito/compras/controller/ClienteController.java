package com.clientes.carrito.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.carrito.compras.model.Cliente;
import com.clientes.carrito.compras.model.Productos;
import com.clientes.carrito.compras.services.CrudServices;

@RestController
@RequestMapping("clientes")
@CrossOrigin
public class ClienteController  {


	@Autowired
	CrudServices service;

	@PostMapping("add")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return service.add(cliente);
	}

	@PutMapping("update")
	public Cliente update(@RequestBody Cliente cliente) {
		return service.update(cliente);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}

	@GetMapping("search/{id}")
	public Cliente buscar(@PathVariable int id) {
		return service.search(id);
	}

	@GetMapping("allshow")
	public List<Cliente> listarClientes() {
		return service.allshow();
	}
	
	@PutMapping("addProducto/{idcliente}/{idproducto}/{cantidad}")
	public Cliente addProducto(@PathVariable int idcliente,@PathVariable int idproducto,@PathVariable int cantidad) {
		return service.addproductoCliente( idcliente,   idproducto,  cantidad);
	}
	@PutMapping("rmvProducto/{idcliente}/{idproducto}")
	public Cliente rmvProducto(@PathVariable int idcliente,@PathVariable int idproducto) {
		return service.rmvaddproductoCliente( idcliente,   idproducto);
	}
	
	
	@GetMapping("showProductos")
	public List<Productos> listProductos() {
		return service.showProductos();
	}
}
