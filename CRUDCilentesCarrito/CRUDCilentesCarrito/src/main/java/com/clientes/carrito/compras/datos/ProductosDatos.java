package com.clientes.carrito.compras.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clientes.carrito.compras.model.Productos;


public class ProductosDatos {

	
	private List <Productos> listaProductos ;
	private Map<Integer, Productos> MapPro;
	public List<Productos> getListaP() {
		return listaProductos;
	}

	public void setListaP(List<Productos> listaP) {
		this.listaProductos = listaP;
	}

	public List <Productos> productos () {
		

		listaProductos= new ArrayList< Productos>();
		MapPro = new HashMap<>();
		Productos p1= new Productos(1,"leche","Area de lacteos",23.5,0);
		listaProductos.add(p1);
		MapPro.put(p1.getId(), p1);
		
		Productos p2= new Productos(2,"Cereal","Granos",23.5,0);
		listaProductos.add(p2);
		MapPro.put(p2.getId(), p2);
		
		Productos p3= new Productos(3,"Cafe","Area de azucares y otros",23.5,0);
		listaProductos.add(p3);
		MapPro.put(p3.getId(), p3);
		
		Productos p4= new Productos(4,"Gelatina","Area de azucares y otros",23.5,0);
		listaProductos.add(p4);
		MapPro.put(p4.getId(), p4);
		
		Productos p5= new Productos(5,"Galletas maria","Area de azucares y otros",23.5,0);
		listaProductos.add(p5);
		MapPro.put(p5.getId(), p5);
		
		Productos p6= new Productos(6,"Coca cola","Refrescos ",23.5,0);
		listaProductos.add(p6);
		MapPro.put(p6.getId(), p6);
		
	
//		return (List<Productos>) listaP.stream().filter(p->p.getId()==1 );
		return listaProductos;
	}
	
	public boolean buscar (int id) {
		boolean repuesta =false;
		if (this.listaProductos.stream().filter(p->p.getId()==id )!=null) {
			return repuesta =true;
		}
		return repuesta ;
	}
	
	public Productos optenerproducto (int id) {

		return  MapPro.get(id);
	}
}
