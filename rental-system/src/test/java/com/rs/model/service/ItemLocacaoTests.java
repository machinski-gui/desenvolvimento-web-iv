package com.rs.model.service;

import java.util.List;

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
