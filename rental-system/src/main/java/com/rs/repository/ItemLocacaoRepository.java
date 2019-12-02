package com.rs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rs.entity.Equipamento;
import com.rs.entity.ItemLocacao;
import com.rs.entity.Locacao;

public interface ItemLocacaoRepository extends JpaRepository<ItemLocacao, Long> {

	@Query("FROM ItemLocacao itemLocacao ORDER BY itemLocacao.quantidade DESC")
	public Page<ItemLocacao> findItemLocacaoQuantidade(@Param("locacao") Locacao locacao, @Param("equipamento") Equipamento equipamento, @Param("quantidade") Integer quantidade, @Param("valorUnitario") double valorUnitario, Pageable pageable);
	
	@Query("FROM ItemLocacao itemLocacao WHERE itemLocacao.locacao = :id")
	public Page<ItemLocacao> detalharItemLocacao(@Param("id") Locacao id, Pageable pageable);
}
