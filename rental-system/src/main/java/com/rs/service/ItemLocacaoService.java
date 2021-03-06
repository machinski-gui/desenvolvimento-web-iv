package com.rs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.ItemLocacao;
import com.rs.entity.Locacao;
import com.rs.repository.ItemLocacaoRepository;

@Service
@Transactional
public class ItemLocacaoService {
	
	@Autowired
	private ItemLocacaoRepository itemLocacaoRepository;
	
	public ItemLocacao cadastrarItemLocacao(ItemLocacao itemLocacao) {
		return this.itemLocacaoRepository.save(itemLocacao);
	}
	
	public List<ItemLocacao> listarItemLocacao() {
		return this.itemLocacaoRepository.findAll();
	}
	
	public List<ItemLocacao> detalharItemLocacao(long id) {
		Locacao locacao = new Locacao();
		locacao.setId(id);
		return this.itemLocacaoRepository.detalharItemLocacao(locacao, null).getContent();
	}
	
	public ItemLocacao atualizarItemLocacao(ItemLocacao itemLocacao) {
		return this.itemLocacaoRepository.save(itemLocacao);
	}
	
	public void removerItemLocacao(long id) {
		this.itemLocacaoRepository.deleteById(id);
	}
}
