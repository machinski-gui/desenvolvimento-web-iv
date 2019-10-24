package com.rs.model.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
