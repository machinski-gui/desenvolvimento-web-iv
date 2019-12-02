package com.rs.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.Cliente;
import com.rs.service.ClienteService;

@Component
@RestController
@RequestMapping( "/api/cliente" )
public class ClienteResource {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/list")
	public List<Cliente> listar() {
		return this.clienteService.listarClientes();
	}	
}



