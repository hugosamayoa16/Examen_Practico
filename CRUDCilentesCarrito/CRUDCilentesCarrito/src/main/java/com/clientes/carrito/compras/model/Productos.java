package com.clientes.carrito.compras.model;

public class Productos {
	private int id;
	private String nombre;
	private String descripcinn;
	private double precio;
	private int cantidad;
	
	public Productos() {
		
	}
	public Productos(int id, String nombre, String descripcinn, double precio, int cantidad) {

		this.id = id;
		this.nombre = nombre;
		this.descripcinn = descripcinn;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcinn() {
		return descripcinn;
	}
	public void setDescripcinn(String descripcinn) {
		this.descripcinn = descripcinn;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
