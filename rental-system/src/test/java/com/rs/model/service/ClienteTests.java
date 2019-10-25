package com.rs.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.Cliente;
import com.rs.entity.TipoEnum;
import com.rs.repository.ClienteRepository;
import com.rs.service.ClienteService;

public class ClienteTests extends AbstractIntegrationTests {

	@Autowired
	private ClienteService clienteService;
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * ========================= CADASTRAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPass() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
		Assert.assertNotNull(cliente.getId());
	}
	
	/**
	 * ========================= LISTAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/cliente.sql"})
	public void listarClienteMustPass() {
		List<Cliente> clientes = this.clienteRepository.findAll();
		Assert.assertEquals(clientes.size(), 1);
	}
	
	/**
	 * ========================= ATUALIZAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPass( ) {
		Cliente cliente = this.clienteRepository.findById(2L).orElse(null);
		cliente.setNome("Joao Souza");
		clienteService.atualizarCliente(cliente);
		Assert.assertTrue(cliente.getNome().equals("Joao Souza"));
	}
	
	/**
	 * ========================= REMOVER =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void removerClienteMustPass() {
		this.clienteService.removerCliente(2);
		Cliente cliente = this.clienteRepository.findById(2L).orElse(null);
		Assert.assertNull(cliente);
		
	}
}
