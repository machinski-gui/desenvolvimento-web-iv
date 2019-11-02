package com.rs.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.CargoEnum;
import com.rs.entity.Funcionario;
import com.rs.repository.FuncionarioRepository;
import com.rs.service.FuncionarioService;


public class FuncionarioTests extends AbstractIntegrationTests {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	/**
	 * ========================= CADASTRAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void cadastrarFuncionarioMustPass() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Cleberson");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.cadastrarFuncionario(funcionario);
		Assert.assertNotNull(funcionario.getId());
	}
			
	/**
	 * ========================= LISTAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void listarFuncionarioMustPass() {
		List<Funcionario> funcionarios = this.funcionarioService.listarFuncionarios();
		Assert.assertEquals(funcionarios.size(), 1);
	}
	
	/**
	 * ========================= ATUALIZAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void atualizarFuncionarioMustPass() {
		Funcionario funcionario = this.funcionarioRepository.findById(2L).orElse(null);
		funcionario.setSenha("4321");
		funcionarioService.atualizarFuncionario(funcionario);
		Assert.assertTrue(funcionario.getSenha().equals("4321"));
	}
	
	/**
	 * ========================= REMOVER =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void removerFuncionarioMustPass() {
		this.funcionarioService.removerFuncionario(2);
		Funcionario funcionario = this.funcionarioRepository.findById(2L).orElse(null);
		Assert.assertNull(funcionario);
	}
}
