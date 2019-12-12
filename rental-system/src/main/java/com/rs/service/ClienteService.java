package com.rs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.Cliente;
import com.rs.entity.Equipamento;
import com.rs.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente atualizarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente detalharCliente(long id) {
		return this.clienteRepository.findById(id).orElse(null);
	}
	
	public void removerCliente(long id) {
		this.clienteRepository.deleteById(id);
	}
}
