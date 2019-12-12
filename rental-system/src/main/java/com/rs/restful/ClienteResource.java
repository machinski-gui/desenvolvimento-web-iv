package com.rs.restful;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.Cliente;
import com.rs.entity.Equipamento;
import com.rs.service.ClienteService;

@Component
@RestController
@RequestMapping( "/api/cliente" )
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/insert")
	public Cliente cadastrar( @RequestBody Cliente cliente ) {
		return this.clienteService.cadastrarCliente(cliente);
	}
	
	@GetMapping("/list")
	public List<Cliente> listar() {
		return this.clienteService.listarClientes();
	}	
	
	@PostMapping("/update")
	public Cliente atualizar( @RequestBody Cliente cliente ) {
		return this.clienteService.atualizarCliente(cliente);
	}
	
	@GetMapping("/find")
	public Cliente detalhar(@RequestParam("id") Long id) {
		return this.clienteService.detalharCliente(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.clienteService.removerCliente(id);
	}
}



