package com.rs.model.service;

import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.rs.entity.Equipamento;
import com.rs.entity.ItemLocacao;
import com.rs.entity.Locacao;
import com.rs.repository.EquipamentoRepository;
import com.rs.repository.ItemLocacaoRepository;
import com.rs.repository.LocacaoRepository;
import com.rs.service.ItemLocacaoService;

public class ItemLocacaoTests extends AbstractIntegrationTests {
	
	@Autowired
	private ItemLocacaoService itemLocacaoService;
	
	@Autowired
	private ItemLocacaoRepository itemLocacaoRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	/**
	 * ========================= CADASTRAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarItemLocacaoMustPass() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(locacao);
		itemLocacao.setEquipamento(equipamento);
		itemLocacao.setQuantidade(25);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.cadastrarItemLocacao(itemLocacao);
		Assert.assertNotNull(itemLocacao.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarItemLocacaoMustFailLocacaoEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(null);
		itemLocacao.setEquipamento(equipamento);
		itemLocacao.setQuantidade(25);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.cadastrarItemLocacao(itemLocacao);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarItemLocacaoMustFailEquipamentoEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(locacao);
		itemLocacao.setEquipamento(null);
		itemLocacao.setQuantidade(25);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.cadastrarItemLocacao(itemLocacao);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void cadastrarItemLocacaoMustFailQuantidadeEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(locacao);
		itemLocacao.setEquipamento(equipamento);
		itemLocacao.setQuantidade(null);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.cadastrarItemLocacao(itemLocacao);
	}
	
	/**
	 * ========================= LISTAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql",
		"/dataset/itemLocacao.sql"})
	public void listarLocacaoMustPass() {
		List<ItemLocacao> itemLocacoes = this.itemLocacaoService.listarItemLocacao();
		Assert.assertEquals(itemLocacoes.size(), 1);
	}
	
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql",
		"/dataset/itemLocacao.sql"})
	public void listarLocacaoMustPassQuantidade() {
		List<ItemLocacao> itemLocacoes = this.itemLocacaoRepository.findItemLocacaoQuantidade(null, null, null, 0, null).getContent();
		Assert.assertEquals(itemLocacoes.size(), 1);
	}
	
	/**
	 * ========================= ATUALIZAR =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql",
		"/dataset/itemLocacao.sql"})
	public void atualizarItemLocacaoMustPass() {
		ItemLocacao itemLocacao = this.itemLocacaoRepository.findById(1L).orElse(null);
		itemLocacao.setQuantidade(500);
		itemLocacaoService.atualizarItemLocacao(itemLocacao);
		Assert.assertTrue(itemLocacao.getQuantidade() == 500);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void atualizarItemLocacaoMustFailLocacaoEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(null);
		itemLocacao.setEquipamento(equipamento);
		itemLocacao.setQuantidade(25);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.atualizarItemLocacao(itemLocacao);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void atualizarItemLocacaoMustFailEquipamentoEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(locacao);
		itemLocacao.setEquipamento(null);
		itemLocacao.setQuantidade(25);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.atualizarItemLocacao(itemLocacao);
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql"})
	public void atualizarItemLocacaoMustFailQuantidadeEmBranco() {
		Locacao locacao = this.locacaoRepository.findById(2L).orElse(null);
		Equipamento equipamento = this.equipamentoRepository.findById(2L).orElse(null);
		ItemLocacao itemLocacao = new ItemLocacao();
		itemLocacao.setLocacao(locacao);
		itemLocacao.setEquipamento(equipamento);
		itemLocacao.setQuantidade(null);
		itemLocacao.setValorUnitario(2500);
		itemLocacaoService.atualizarItemLocacao(itemLocacao);
	}
	
	/**
	 * ========================= REMOVER =========================
	 */
	@Test
	@Sql({"/dataset/truncate.sql",
		"/dataset/cliente.sql",
		"/dataset/funcionario.sql",
		"/dataset/locacao.sql",
		"/dataset/equipamento.sql",
		"/dataset/itemLocacao.sql"})
	public void removerItemLocacaoMustPass() {
		this.itemLocacaoService.removerItemLocacao(1);
		ItemLocacao itemLocacao = this.itemLocacaoRepository.findById(1L).orElse(null);
		Assert.assertNull(itemLocacao);
	}
}
