package com.rs.model.service;

import java.util.List;

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
	public void atualizarEquipamentoMustPass() {
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		equipamento.setPrecoLocacao(700);
		equipamentoService.atualizarEquipamento(equipamento);
		Assert.assertTrue(equipamento.getPrecoLocacao() == 700);
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
