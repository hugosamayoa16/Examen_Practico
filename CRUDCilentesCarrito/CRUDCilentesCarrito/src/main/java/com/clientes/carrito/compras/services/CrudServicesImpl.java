package com.clientes.carrito.compras.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientes.carrito.compras.dao.ClientesDaoThread;
import com.clientes.carrito.compras.datos.ProductosDatos;
import com.clientes.carrito.compras.model.Cliente;
import com.clientes.carrito.compras.model.ClienteRespose;
import com.clientes.carrito.compras.model.Productos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CrudServicesImpl implements CrudServices{


	private File file;
	private HashMap<Integer, Cliente> clientes;
	private ObjectMapper mapper;
	private int id = 0;
	private ProductosDatos productos;
	CrudServicesImpl() {
		try {
			file = new File("C:\\Users\\NS-608\\Documents\\Json\\clientes.json");
			clientes = new HashMap<Integer, Cliente>();
			mapper = new ObjectMapper();
			productos= new ProductosDatos();
			productos.productos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente add(Cliente cliente) {
		

		id++;
		List<Productos>p=new ArrayList<>();
		cliente.setListaProductos(p);
		cliente.setClienteid(id);

		clientes.put(id, cliente);
		this.mantener(file, clientes);
		return new Cliente(id, cliente.getNombre(), cliente.getEdad(), cliente.getSexo(), cliente.getListaProductos());
	}

	@Override
	public Cliente update(Cliente cliente) {//
		clientes.put(cliente.getClienteid(), cliente);
		this.mantener(file, clientes);
		return new Cliente(cliente.getClienteid(), cliente.getNombre(), cliente.getEdad(), cliente.getSexo(),
				cliente.getListaProductos());
	}

	@Override
	public String delete(int id) {
		try {
			HashMap<Integer, Cliente> cliente = this.leerJson();
			if (search(id) != null) {
				cliente.remove(id);
				this.mantener(file, cliente);

			} else {
				return "No se encuentra el registro a eliminar!!!!";

			}

		} catch (Exception e) {
			return "ocurrio un error al eliminar";
		}
		return "Eliminado correctamente!!";

	}

	@Override
	public Cliente search(int id) {
		return this.leerJson().get(id);
	}

	@Override
	public List<Cliente> allshow() {
		List<Cliente> listClientes = new ArrayList<Cliente>();
		for (Integer key : this.leerJson().keySet()) {
			listClientes.add(this.leerJson().get(key));
		}
		return listClientes;
	}

	public HashMap<Integer, Cliente>leerJson () {
		HashMap<Integer, Cliente> clientesExistentes = new HashMap<Integer, Cliente>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inStr = new FileInputStream(file);
			TypeReference<HashMap<Integer, Cliente>> typeReference = new TypeReference<HashMap<Integer, Cliente>>() {
			};
			clientesExistentes = mapper.readValue(inStr, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientesExistentes;
	}

	public void mantener(File file, HashMap<Integer, Cliente> hashM) {
		try {
			mapper.writeValue(file, hashM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public ClienteRespose addproductoCliente(int idcliente, int  idproducto, int cantidad) {
		Cliente client=
		this.leerJson().get(idcliente);
		ClienteRespose resp= new ClienteRespose();
		
		productos.productos();//SE INICAN LAS VARIABLES DE LA LISTA DE PRODUCTOS 
		if(productos.buscar(idproducto)) {//SE VERIFICA SI EL PRODUCTO A REGISTRAR EXISTE 
			
			Productos productoDTO= new Productos();
			productoDTO=productos.optenerproducto(idproducto);//SE OPTIENE EL PRODUCTO 
			  if(cantidad>0) {//	VALIDA QUE LA CANTIDAD DEL PRUDUCTO SEA MAYOR A 0
			 productoDTO.setCantidad(cantidad);//SE INGRESA LA CONTIDAD 
			 
			 List<Productos>p=new ArrayList<>();
			 p=client.getListaProductos();//SE OPTIENEN LOS PRODUCTOS QUE EL USUARIO TIENE POR EL MOMENTO 
			  
			 p.add(productoDTO);//SE AGREGA EL NUEVO PRODUCTO 
			 ClientesDaoThread mh= new ClientesDaoThread();
			 Thread nuevoh=new Thread(mh);
			 nuevoh.start();
			 client.setListaProductos(p);
			 update( client);
			  } else {
				  resp.setCliente(this.leerJson().get(idcliente));
					resp.setDescripcion("ERROR EN EL REGISTRO, LA CANTIDAD DEBE DE SER MAYOR A 0");
					return resp;
			  }
			
		}else {
			 resp.setCliente(this.leerJson().get(idcliente));
				resp.setDescripcion("ERROR EN EL REGISTRO, EL ARTICULO NO EXISTE");
				return resp;
		}
		resp.setCliente(this.leerJson().get(idcliente));
		resp.setDescripcion("Registro esxitoso");
		return resp;
	}
	
	@Override
	public Cliente rmvaddproductoCliente(int idcliente, int  idproducto) {
		Cliente client=
				this.leerJson().get(idcliente);
		
//				CONDICION PÁRA VERIFICACR SI EXISTE EL IDE EN LA LISTA DE PRODUCTOS
				if(productos.buscar(idproducto)) {
					

//					 Productos productoDTO=productos.optenerproducto(idproducto);
					 List<Productos>p= client.getListaProductos();
					 
//						CONDICION PARA VERIFICAR SI EXISTE EL PRODUCTO DENTRO DE LA LISTA DE PRODUCTOS DEL CLIENTE 
					 if(buscarProductosCliente(idproducto,p)) {

//						 p.add(productoDTO);
						 
						 p.remove(indexlist(idproducto,p));
						 client.setListaProductos(p);
						 update( client);
					 }
					
				}
				
				return this.leerJson().get(idcliente);
	}
	@Override
	public List <Productos> showProductos(){
		return productos.productos();
	}

	public int indexlist (int id,  List<Productos> lista) {
		int resp= 0;
	for(int i=0; i<=lista.size(); i++) {
		
		if(lista.get(i).getId()==id) {
			resp=i;
			break;
		}
		
	}
	return resp;
	}
	
	
	public boolean buscarProductosCliente (int id,List<Productos> lista) {
		boolean repuesta =false;
		if (lista.stream().filter(p->p.getId()==id )!=null) {
			return repuesta =true;
		}
		return repuesta ;
	}
	
	@Override
	public ResponseEntity<String>  consumo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response
		  = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);
		
//		ClienteRespose objects=restTemplate
//				  .getForObject("https://jsonplaceholder.typicode.com/posts", ClienteRespose .class);
		
		return response;
		
	}
	
}
