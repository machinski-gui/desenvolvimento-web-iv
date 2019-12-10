package com.rs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.Locacao;
import com.rs.repository.LocacaoRepository;

@Service
@Transactional
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;
	
	public Locacao cadastrarLocacao(Locacao locacao) {
		return this.locacaoRepository.save(locacao);
	}
	
	public List<Locacao> listarLocacoes() {
		return this.locacaoRepository.findTrue(null, null, null, null, 0, false, null).getContent();
	}
	
	public List<Locacao> listarLocacoesInativas() {
		return this.locacaoRepository.findFalse(null, null, null, null, 0, false, null).getContent();
	}
	
	public Locacao atualizarLocacao(Locacao locacao) {
		return this.locacaoRepository.save(locacao);
	}
	
	public void removerLocacao(long id) {
		this.locacaoRepository.deleteById(id);
	}
}
