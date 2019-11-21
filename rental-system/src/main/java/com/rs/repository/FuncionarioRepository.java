package com.rs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rs.entity.Cliente;
import com.rs.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query("FROM Funcionario funcionario WHERE funcionario.cargo = 0")
	public Page<Funcionario> findPorCargoFuncionario(@Param("usuario") String usuario, @Param("senha") String senha, @Param("cargo") String cargo, Pageable pageable);
}
