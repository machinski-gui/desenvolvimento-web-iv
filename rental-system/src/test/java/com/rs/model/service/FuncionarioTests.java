package com.rs.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	@Sql({"/dataset/truncate.sql"})
	public void cadastrarFuncionarioMustPass() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Cleberson");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.cadastrarFuncionario(funcionario);
		Assert.assertNotNull(funcionario.getId());
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void cadastrarFuncionarioMustFailUsuarioDuplicado() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Guilherme");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.cadastrarFuncionario(funcionario);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",  
	"/dataset/funcionario.sql"})
	public void cadastrarFuncionarioMustFailUsuarioEmBranco() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.cadastrarFuncionario(funcionario);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",  
	"/dataset/funcionario.sql"})
	public void cadastrarFuncionarioMustFailSenhaEmBranco() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Cleison");
		funcionario.setSenha("");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.cadastrarFuncionario(funcionario);
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
	
	@Test(expected = DataIntegrityViolationException.class)
	@Sql({"/dataset/truncate.sql",  
		"/dataset/funcionario.sql"})
	public void atualizarFuncionarioMustFailUsuarioDuplicado() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Guilherme");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.atualizarFuncionario(funcionario);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",  
	"/dataset/funcionario.sql"})
	public void atualizarFuncionarioMustFailUsuarioEmBranco() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("");
		funcionario.setSenha("1234");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.atualizarFuncionario(funcionario);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",  
	"/dataset/funcionario.sql"})
	public void atualizarFuncionarioMustFailSenhaEmBranco() {
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario("Cleison");
		funcionario.setSenha("");
		funcionario.setCargo(CargoEnum.FUNCIONARIO);
		funcionarioService.atualizarFuncionario(funcionario);
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
