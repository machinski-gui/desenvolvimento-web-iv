package com.rs.model.service;

import java.util.List;

import javax.swing.JOptionPane;
import javax.validation.ValidationException;

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
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassNomeEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("");
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
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassCpfCnpjEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("");
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
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassLogradouroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("");
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
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassNumeroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassBairroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassMunicipioEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassEstadoEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassCepEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassTelefoneVazio() {
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
		cliente.setTelefone("");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassCelularVazio() {
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
		cliente.setCelular("");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void cadastrarClienteMustPassEmailVazio() {
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
		cliente.setEmail("");
		cliente.setClienteAtivo(true);
		clienteService.cadastrarCliente(cliente);
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
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/cliente.sql"})
	public void listarClienteMustPassPorOrdemAlfabetica() {
		List<Cliente> clientes = this.clienteRepository.findOrdemAlfabetica(null, null, null, null, null, null, null, null, null, null, null, null, true, null).getContent();
		Assert.assertEquals(clientes.size(), 1);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/cliente.sql"})
	public void listarClienteMustPassClienteAtivo() {
		List<Cliente> clientes = this.clienteRepository.findClienteAtivo(null, null, null, null, null, null, null, null, null, null, null, null, true, null).getContent();
		Assert.assertEquals(clientes.size(), 1);
	}	
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/cliente.sql"})
	public void listarClienteMustPassClienteInativo() {
		List<Cliente> clientes = this.clienteRepository.findClienteInativo(null, null, null, null, null, null, null, null, null, null, null, null, true, null).getContent();
		Assert.assertEquals(clientes.size(), 0);
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
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassNomeEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("");
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
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassCpfCnpjEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("");
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
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassLogradouroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassNumeroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassBairroEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassMunicipioEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("");
		cliente.setEstado("Paraná");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassEstadoEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("");
		cliente.setCep("85868-200");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassCepEmBranco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Guilherme Machinski");
		cliente.setCpf_cnpj("124.753.339-52");
		cliente.setTipo(TipoEnum.FÍSICA);
		cliente.setLogradouro("Rua Vila Rica");
		cliente.setNumero("244");
		cliente.setBairro("Jardim Petropolis");
		cliente.setMunicipio("Foz do Iguaçu");
		cliente.setEstado("Paraná");
		cliente.setCep("");
		cliente.setTelefone("(45)3575-6524");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassTelefoneVazio() {
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
		cliente.setTelefone("");
		cliente.setCelular("(45)99851-9757");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassCelularVazio() {
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
		cliente.setCelular("");
		cliente.setEmail("machinski_gui@outlook.com");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql"})
	public void atualizarClienteMustPassEmailVazio() {
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
		cliente.setEmail("");
		cliente.setClienteAtivo(true);
		clienteService.atualizarCliente(cliente);
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
