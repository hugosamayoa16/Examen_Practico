package com.clientes.carrito.compras.model;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteRespose {

	@JsonProperty("cliente")
	Cliente cliente;
	@JsonProperty("descripcion")
	String descripcion;
	
	public ClienteRespose(	){}
//	@ConstructorProperties({ "cliente","descripcion"})
//	public ClienteRespose(	String descripcion,Cliente cliente){
//		this.cliente=cliente;
//		this.descripcion=descripcion;
//	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	}
