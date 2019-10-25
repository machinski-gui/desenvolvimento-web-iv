package com.rs.model.service;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.Cliente;
import com.rs.entity.Funcionario;
import com.rs.entity.Locacao;
import com.rs.repository.ClienteRepository;
import com.rs.repository.FuncionarioRepository;
import com.rs.repository.LocacaoRepository;
import com.rs.service.LocacaoService;
import com.sun.mail.iap.ByteArray;

public class LocacaoTests extends AbstractIntegrationTests {

	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	/**
	 * ========================= CADASTRAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/locacao.sql",
		"/dataset/cliente.sql"})
	public void cadastrarLocacaoMustPass() {
		Cliente cliente = this.clienteRepository.findById(2L).orElse(null);
		Funcionario funcionario = this.funcionarioRepository.findById(2L).orElse(null);
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setFuncionario(funcionario);
		locacao.setDataEmprestimo(LocalDateTime.now());
		locacao.setDataDevolucao(LocalDateTime.now());
		locacao.setValorTotal(300);
		locacao.setLocacaoAtivo(true);
	}



}
