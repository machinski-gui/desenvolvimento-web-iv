package com.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.entity.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
