package com.rs.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.Funcionario;
import com.rs.service.FuncionarioService;


public class FuncionarioTests extends AbstractIntegrationTests {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Test
	@Sql( 
		"/dataset/funcionarios.sql"
		)
	public void listarFuncionarioMustPass() {
		List<Funcionario> funcionarios = this.funcionarioService.listarFuncionarios();
		Assert.assertEquals(funcionarios.size(), 1);
	}
}
