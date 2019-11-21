package com.rs.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.Equipamento;
import com.rs.repository.EquipamentoRepository;
import com.rs.service.EquipamentoService;

public class EquipamentoTests extends AbstractIntegrationTests {

	@Autowired
	private EquipamentoService equipamentoService;
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;

	/**
	 * ========================= CADASTRAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarEquipamentoMustPass() {
		Equipamento equipamento = new Equipamento();
		equipamento.setCodigo("7891-2541");
		equipamento.setDescricao("MESA DE SOM BEHRINGER 4 CANAIS");
		equipamento.setPrecoEquipamento(350);
		equipamento.setPrecoLocacao(35);
		equipamento.setEstoque(5);
		equipamento.setEquipamentoAtivo(true);
		equipamentoService.cadastrarEquipamento(equipamento);
		Assert.assertNotNull(equipamento.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarEquipamentoMustFailCodigoEmBranco() {
		Equipamento equipamento = new Equipamento();
		equipamento.setCodigo("");
		equipamento.setDescricao("MESA DE SOM BEHRINGER 4 CANAIS");
		equipamento.setPrecoEquipamento(350);
		equipamento.setPrecoLocacao(35);
		equipamento.setEstoque(5);
		equipamento.setEquipamentoAtivo(true);
		equipamentoService.cadastrarEquipamento(equipamento);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarEquipamentoMustFailDescricaoEmBranco() {
		Equipamento equipamento = new Equipamento();
		equipamento.setCodigo("7891-2541");
		equipamento.setDescricao("");
		equipamento.setPrecoEquipamento(350);
		equipamento.setPrecoLocacao(35);
		equipamento.setEstoque(5);
		equipamento.setEquipamentoAtivo(true);
		equipamentoService.cadastrarEquipamento(equipamento);
	}	
	
	/**
	 * ========================= LISTAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void listarEquipamentoMustPass() {
		List<Equipamento> equipamentos = this.equipamentoService.listarEquipamento();
		Assert.assertEquals(equipamentos.size(), 1);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void listarEquipamentoMustPassPorEstoque() {
		List<Equipamento> equipamentos = this.equipamentoRepository.findEquipamentoPorEstoque(null, null, 0, 0, null, true, null).getContent();
		Assert.assertEquals(equipamentos.size(), 1);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void listarEquipamentoMustPassComEstoqueZero() {
		List<Equipamento> equipamentos = this.equipamentoRepository.findEquipamentoComEstoqueZero(null, null, 0, 0, null, true, null).getContent();
		Assert.assertEquals(equipamentos.size(), 0);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void listarEquipamentoMustPassAtivo() {
		List<Equipamento> equipamentos = this.equipamentoRepository.findEquipamentoAtivo(null, null, 0, 0, null, true, null).getContent();
		Assert.assertEquals(equipamentos.size(), 1);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void listarEquipamentoMustPassComInativo() {
		List<Equipamento> equipamentos = this.equipamentoRepository.findEquipamentoInativo(null, null, 0, 0, null, false, null).getContent();
		Assert.assertEquals(equipamentos.size(), 0);
	}
	
	/**
	 * ========================= ATUALIZAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void atualizarEquipamentoMustPass() {
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		equipamento.setPrecoLocacao(700);
		equipamentoService.atualizarEquipamento(equipamento);
		Assert.assertTrue(equipamento.getPrecoLocacao() == 700);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/equipamento.sql"})
	public void atualizarEquipamentoMustFailCodigoEmBranco() {
		Equipamento equipamento = new Equipamento();
		equipamento.setCodigo("");
		equipamento.setDescricao("MESA DE SOM BEHRINGER 4 CANAIS");
		equipamento.setPrecoEquipamento(350);
		equipamento.setPrecoLocacao(35);
		equipamento.setEstoque(5);
		equipamento.setEquipamentoAtivo(true);
		equipamentoService.atualizarEquipamento(equipamento);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/equipamento.sql"})
	public void atualizarEquipamentoMustFailDescricaoEmBranco() {
		Equipamento equipamento = new Equipamento();
		equipamento.setCodigo("7891-2541");
		equipamento.setDescricao("");
		equipamento.setPrecoEquipamento(350);
		equipamento.setPrecoLocacao(35);
		equipamento.setEstoque(5);
		equipamento.setEquipamentoAtivo(true);
		equipamentoService.atualizarEquipamento(equipamento);
	}
	
	/**
	 * ========================= REMOVER =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",  
		"/dataset/equipamento.sql"})
	public void removerEquipamentoMustPass() {
		this.equipamentoService.removerEquipamento(2);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		Assert.assertNull(equipamento);
	}
}
