package com.rs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.entity.Funcionario;
import com.rs.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> listarFuncionarios() {
		return this.funcionarioRepository.findAll();
	}
	
	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}
	
	public void removerFuncionario(long id) {
		this.funcionarioRepository.deleteById(id);
	}	
}
