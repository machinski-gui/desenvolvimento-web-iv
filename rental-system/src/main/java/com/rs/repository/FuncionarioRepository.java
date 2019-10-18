package com.rs.repository;


import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rs.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	//@Override
//	/@EntityGraph(attributePaths = "cargo")
	//public Optional<Funcionario> findById(Long id);

	//@Query("")
	//public Page<Funcionario> findByFilters(@Param("usuario") String usuario, Pageable pageable);
}
