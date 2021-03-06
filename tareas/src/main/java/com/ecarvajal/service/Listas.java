package com.ecarvajal.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecarvajal.model.Cliente;
import com.ecarvajal.model.Mantenimiento;
import com.ecarvajal.model.Producto;


@Service
public class Listas {
	
	
	public List<Mantenimiento> getMantenimientos(int id_cliente){
		System.out.println(" -- Get Lista Mantenimientos -- ");
		SimpleDateFormat formatear = new SimpleDateFormat("dd-mm-yyyy");
		List<Mantenimiento> lista = new LinkedList<Mantenimiento>();
		
		try {
			Mantenimiento mant1 = new Mantenimiento();
			mant1.setId(1);
			mant1.setId_client(1);
			mant1.setDescripcion("Cadena");
			mant1.setFalta(formatear.parse("31-07-2020"));
			mant1.setFalerta(formatear.parse("30-10-2020"));
			
			Mantenimiento mant2 = new Mantenimiento();
			mant2.setId(2);
			mant2.setId_client(1);
			mant2.setDescripcion("Rueda delantera");
			mant2.setFalta(formatear.parse("31-07-2020"));
			mant2.setFalerta(formatear.parse("30-11-2020"));
			
			
			Mantenimiento mant3 = new Mantenimiento();
			mant3.setId(3);
			mant3.setId_client(1);
			mant3.setDescripcion("Rueda trasera");
			mant3.setFalta(formatear.parse("31-07-2020"));
			mant3.setFalerta(formatear.parse("3-12-2020"));
			
			
			Mantenimiento mant4 = new Mantenimiento();
			mant4.setId(4);
			mant4.setId_client(1);
			mant4.setDescripcion("Rodamientos pedalier");
			mant4.setFalta(formatear.parse("31-07-2020"));
			mant4.setFalerta(formatear.parse("3-1-2021"));
			
			Mantenimiento mant5 = new Mantenimiento();
			mant5.setId(5);
			mant5.setId_client(2);
			mant5.setDescripcion("Cadena");
			mant5.setFalta(formatear.parse("31-07-2020"));
			mant5.setFalerta(formatear.parse("3-11-2020"));
			
			if (mant1.getId_client() == id_cliente) lista.add(mant1);
			if (mant2.getId_client() == id_cliente) lista.add(mant2);
			if (mant3.getId_client() == id_cliente) lista.add(mant3);
			if (mant4.getId_client() == id_cliente) lista.add(mant4);
			if (mant5.getId_client() == id_cliente) lista.add(mant5);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	/*
	 * Lista ficticia auto generada ficticia temporal.
	 * 
	 * 
	 */
	public List<Cliente> getClientes(){
		System.out.println(" GetLista Clientes ");
		//SimpleDateFormat formatear = new SimpleDateFormat("dd-mm-yyyy");
		List<Cliente> lista = new LinkedList<Cliente>();
		
		try {
			
			Cliente cliente1 = new Cliente();
			cliente1.setId(1);
			cliente1.setNombre("Fran");
			cliente1.setApellido1("Garcia");
			cliente1.setApellido2("Garcia");
			cliente1.setDireccion("Lepanto 9");
			cliente1.setEmail("FranGG@gmail.com");
			cliente1.setTelefono(67565432);
			cliente1.setObservaciones("Muy majo");
			cliente1.setMunicipio("San Lorenzo");
			
			Cliente cliente2 = new Cliente();
			cliente2.setId(2);
			cliente2.setNombre("Marck");
			cliente2.setApellido1("Jara");
			cliente2.setApellido2("Ruiz");
			cliente2.setDireccion("Lepanto 4");
			cliente2.setEmail("MarckJR@gmail.com");
			cliente2.setTelefono(67455432);
			cliente2.setObservaciones("---");
			cliente2.setMunicipio("Lorca");
			
			
			Cliente cliente3 = new Cliente();
			cliente3.setId(3);
			cliente3.setNombre("Maria");
			cliente3.setApellido1("Ventero");
			cliente3.setApellido2("Martin");
			cliente3.setDireccion("Carlos II");
			cliente3.setEmail("MariaVC@gmail.com");
			cliente3.setTelefono(63465432);
			cliente3.setObservaciones(":)");
			cliente3.setMunicipio("Cieza");

			
			lista.add(cliente1);
			lista.add(cliente2);
			lista.add(cliente3);
			

			System.out.println(" Tamaño lista: "+lista.size());
			return lista;
			
		}catch(NullPointerException nu) {
			System.out.println(" Localizacion "+nu.getLocalizedMessage());
			System.out.println(" Mensaje : "+nu.getMessage());
			System.out.println(" Causa : "+nu.getCause());
			System.out.println(" Error : "+nu);
			return null;
		}
		
	}
	
	/*
	 * Lista ficticia auto generada ficticia temporal.
	 * 
	 * 
	 */
	public List<Producto> getProductos(){
		System.out.println(" GetLista Productos ");
		//SimpleDateFormat formatear = new SimpleDateFormat("dd-mm-yyyy");
		List<Producto> lista = new LinkedList<Producto>();
		
		try {
			
			Producto producto1 = new Producto();
			producto1.setId(1);
			producto1.setCodProducto("56");
			producto1.setNombre("A2 MIPS 2019 LTD ADIDAS TEAM NAVY / LIGH");
			producto1.setPrecio(153.30);
			producto1.setPvp(143.50);
			producto1.setCategoria("Equipamiento");
			producto1.setSubCategoria("Casco");
			producto1.setStock(4);
			producto1.setPublicado(false);
			producto1.setDescuento(10);
			
			Producto producto2 = new Producto();
			producto2.setId(2);
			producto2.setCodProducto("54");
			producto2.setNombre("RODILLERA FOX LAUNCH PRO D30 2020 NEGRO");
			producto2.setPrecio(130.30);
			producto2.setPvp(150.1);
			producto2.setCategoria("Equipamiento");
			producto2.setSubCategoria("Rodillera");
			producto2.setStock(4);
			producto2.setPublicado(true);
			producto2.setDescuento(12);
			
			Producto producto3 = new Producto();
			producto3.setId(3);
			producto3.setCodProducto("52");
			producto3.setNombre("GUANTE TROY LEE AIR GLOVE 2019 RED L");
			producto3.setPrecio(24);
			producto3.setPvp(30);
			producto3.setCategoria("Equipamiento");
			producto3.setSubCategoria("Guantes");
			producto3.setStock(5);
			producto3.setPublicado(true);
			producto3.setDescuento(15);
		
			lista.add(producto1);
			lista.add(producto2);
			lista.add(producto3);
			

			System.out.println(" Tamaño lista: "+lista.size());
			return lista;
			
		}catch(NullPointerException nu) {
			System.out.println(" Localizacion "+nu.getLocalizedMessage());
			System.out.println(" Mensaje : "+nu.getMessage());
			System.out.println(" Causa : "+nu.getCause());
			System.out.println(" Error : "+nu);
			return null;
		}
		
	}
	
}
