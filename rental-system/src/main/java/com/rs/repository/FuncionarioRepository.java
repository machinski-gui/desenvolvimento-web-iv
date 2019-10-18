package com.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	//@Override
//	/@EntityGraph(attributePaths = "cargo")
	//public Optional<Funcionario> findById(Long id);

	//@Query("")
	//public Page<Funcionario> findByFilters(@Param("usuario") String usuario, Pageable pageable);
}
