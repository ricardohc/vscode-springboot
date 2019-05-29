package com.ejemplo.dumy;

import com.ejemplo.bean.Producto;
import com.ejemplo.bean.Usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/saludar")
	@ResponseBody
	public String saludo(){
		return "hola como estas";
	}

	@RequestMapping(
			value = {"/producto.json","/urlProductoJSON"},
            method = RequestMethod.GET,
            consumes = {"application/json","application/xml"},
            produces = {"application/json"})
	public Producto getProductoJSON(
		@RequestBody Usuario usuario
		){
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getPassword());

		Producto p = new Producto();
		p.setProductoid(100);
		p.setNombre("Seriales");
		p.setPrecio(660.50);
		p.setUsuario(usuario.getLogin());
		return p;
	}

	@RequestMapping(
		value = {"/producto.xml","/urlProductoXML"},
		method = RequestMethod.POST,
		consumes = {"application/xml","application/json"},
		produces = {"application/xml"})
	public Producto getProductoXML(
		@RequestBody Usuario usuario
		){
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getPassword());

		Producto p = new Producto();
		p.setProductoid(100);
		p.setNombre("Seriales");
		p.setPrecio(660.50);
		p.setUsuario(usuario.getLogin());
		return p;
	}


	

}
