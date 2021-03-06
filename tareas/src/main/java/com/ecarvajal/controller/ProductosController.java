package com.ecarvajal.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecarvajal.model.Cliente;
import com.ecarvajal.model.Mantenimiento;
import com.ecarvajal.model.Producto;
import com.ecarvajal.repository.ProductoRepository;
import com.ecarvajal.service.Listas;

@Controller
public class ProductosController {

	@Autowired
	Listas list = new Listas();
	
	public boolean cargaInicial=true;
	public boolean busqueda=false;
	
	List<Producto> productos = new LinkedList<Producto>();
	List<Producto> productosB = new LinkedList<Producto>();
	
	@Autowired
	public ProductoRepository repo;
	
	/*
	 * IMPORTANTE Aqui le estoy pasando el modelo a la vista para tener declarada la variable search en el form de la vista para la busqueda
	 * 
	 * 	
	 */
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("search_producto",new Producto());

	}
	
	
	@GetMapping("/listproductos")
	public String list(Model vista) {
		System.out.println("Vista listado Productos");

		if (productos.isEmpty()  && cargaInicial ) {
			System.out.println("Lista vacia de productos se inicializa ...");
			//Carga inicial de datos.
			productos = list.getProductos();
			cargaInicial=false;
			vista.addAttribute("productos", productos);
		}
		
		if (busqueda) {
			busqueda=false;
			vista.addAttribute("productos", productosB);
			
		}else {

			vista.addAttribute("productos", productos);
		}		
		
		
		
		return "productos/list";
	}
	
	@RequestMapping(value="/alta_producto")
	public String alta(@ModelAttribute("alta_producto") Producto producto) {
		System.out.println(" -- Alta Producto -- Controller --");
		producto.setId(proximoId());
		producto.setPublicado(true);
		productos.add(producto);
		repo.save(producto);
		return "redirect:/"+"listproductos";
	}
	@GetMapping("/deleteProducto/{id}")
	String deleteProducto(@PathVariable("id") int id) {
		System.out.println("-- Eliminado producto id"+id);
		for (int i=0;i<productos.size();i++) {
			if (productos.get(i).getId() == id) {
				productos.remove(i);
			}
		}
		return "redirect:/"+"listproductos";		
	}
	@GetMapping("/search_producto")
	public String searchProducto(@ModelAttribute("search_producto") Producto producto  , BindingResult result, Model vista) {
		productosB.clear();
		if(result.hasErrors()) {
			// fuerzo llegar al controlador aunque tenga campos del producto vacios.
			System.out.println(" -- Hay errores --");
		}
		System.out.println(" -- Search Producto --");
		
		for (int i=0 ;i < productos.size(); i++) {
			if(producto.codproducto.contains(productos.get(i).codproducto ) || producto.codproducto.isEmpty() ) {
				if (producto.nombre.contains(productos.get(i).nombre) || producto.nombre.isEmpty() ) {
					if (producto.precio == productos.get(i).precio || producto.precio == 0.0 ){
						if ( producto.descuento == productos.get(i).descuento || producto.descuento == 0 ) {
							if ( producto.marca.contains(productos.get(i).marca ) || producto.marca.isEmpty() ) {
								if ( producto.modelo.contains(productos.get(i).modelo ) || producto.modelo.isEmpty() ) {
									if ( producto.categoria.contains(productos.get(i).categoria ) || producto.categoria.isEmpty() ) {
										if ( producto.subcategoria.contains(productos.get(i).subcategoria ) || producto.subcategoria.isEmpty() ) {
											if ( producto.stock == productos.get(i).stock  || producto.stock == 0 ) {
												productosB.add(productos.get(i));
											}
										}										
									}									
								}								
							}
						}
						
					}
					
				}
				
			}
		}
		busqueda=true;
		
		return "redirect:/"+"listproductos";
	}
	
	@GetMapping("/stockIncremento/{id}")
	public String controlStockMas(@PathVariable int id ,Model vista) {

		for (int i=0; i< productos.size(); i++) {
			if (productos.get(i).getId()==id) {
				productos.get(i).setStock( productos.get(i).getStock()+1);
				System.out.println("-- Incremento de stock en: "+productos.get(i).toString());
			}
		}

		vista.addAttribute("productos", productos);
		
		return "redirect:/"+"listproductos";
	}
	
	@GetMapping("/stockDecremento/{id}")
	public String controlStockMenos(@PathVariable int id,Model vista) {
		
		for (int i=0; i< productos.size(); i++) {
			if (productos.get(i).getId()==id) {
				productos.get(i).setStock( productos.get(i).getStock()-1);
				System.out.println("-- Decrento de stock en: "+productos.get(i).toString());
			}
		}

		vista.addAttribute("productos", productos);
		
		return "redirect:/"+"listproductos";
	}
	
	@GetMapping("/web/{id}")
	public String publicWeb(@PathVariable int id,Model vista) {
		
		for (int i=0; i< productos.size(); i++) {
			if (productos.get(i).getId()==id) {
				if (productos.get(i).isPublicado()) {
					productos.get(i).setPublicado(false);
					System.out.println("-- Retirado de la Web: "+productos.get(i).toString());
					i=productos.size();
				}else {
					productos.get(i).setPublicado(true);
					System.out.println("-- Añadido a la Web: "+productos.get(i).toString());
					i=productos.size();
				}
			}
		}
		vista.addAttribute("productos", productos);
		return "redirect:/"+"listproductos";
	}
	
	public int proximoId() {
		int id =0;
		
		for(int i=0; i< productos.size() ;i++) {
			if (productos.get(i).getId() > id) id =productos.get(i).getId();
		}

		return id+=1;
	}
}
