package com.rs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.Equipamento;
import com.rs.repository.EquipamentoRepository;

@Service
@Transactional
public class EquipamentoService {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public Equipamento cadastrarEquipamento(Equipamento equipamento) {
		return this.equipamentoRepository.save(equipamento);
	}
	
	public List<Equipamento> listarEquipamento() {
		return this.equipamentoRepository.findAll();
	}
	
	public Equipamento atualizarEquipamento(Equipamento equipamento) {
		return this.equipamentoRepository.save(equipamento);
	}
	
	public void removerEquipamento(long id) {
		this.equipamentoRepository.deleteById(id);
	}
}
