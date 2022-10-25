package com.clientes.carrito.compras.model;

import java.beans.ConstructorProperties;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
	@JsonProperty("clienteid")
	private int clienteid;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("edad")
	private int edad;
	@JsonProperty("sexo")
	private String sexo;
	@JsonProperty("listaProductos")
	List <Productos> listaProductos ;
	
	@ConstructorProperties({ "clienteid",  "nombre",  "edad",  "sexo","listaProductos"})
	public Cliente(int clienteid, String nombre, int edad, String sexo, 	List <Productos> listaProductos ) {
	
		this.clienteid = clienteid;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.listaProductos=listaProductos;
	}

	public List<Productos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



}
