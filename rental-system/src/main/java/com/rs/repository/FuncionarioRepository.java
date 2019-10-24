package com.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
