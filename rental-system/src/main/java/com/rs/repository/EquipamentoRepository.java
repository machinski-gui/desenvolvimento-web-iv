package com.rs.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rs.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

	@Query("FROM Equipamento equipamento ORDER BY equipamento.estoque DESC")
	public Page<Equipamento> findEquipamentoPorEstoque(@Param("codigo") String codigo, @Param("descricao") String descricao, @Param("precoEquipamento") double precoEquipamento, @Param("precoLocacao") double precoLocacao, @Param("estoque") Integer estoque, @Param("equipamentoAtivo") boolean equipamentoAtivo, Pageable pageable);
	
	@Query("FROM Equipamento equipamento WHERE equipamento.estoque = 0")
	public Page<Equipamento> findEquipamentoComEstoqueZero(@Param("codigo") String codigo, @Param("descricao") String descricao, @Param("precoEquipamento") double precoEquipamento, @Param("precoLocacao") double precoLocacao, @Param("estoque") Integer estoque, @Param("equipamentoAtivo") boolean equipamentoAtivo, Pageable pageable);
	
	@Query("FROM Equipamento equipamento WHERE equipamento.equipamentoAtivo = true")
	public Page<Equipamento> findEquipamentoAtivo(@Param("codigo") String codigo, @Param("descricao") String descricao, @Param("precoEquipamento") double precoEquipamento, @Param("precoLocacao") double precoLocacao, @Param("estoque") Integer estoque, @Param("equipamentoAtivo") boolean equipamentoAtivo, Pageable pageable);
	
	@Query("FROM Equipamento equipamento WHERE equipamento.equipamentoAtivo = false")
	public Page<Equipamento> findEquipamentoInativo(@Param("codigo") String codigo, @Param("descricao") String descricao, @Param("precoEquipamento") double precoEquipamento, @Param("precoLocacao") double precoLocacao, @Param("estoque") Integer estoque, @Param("equipamentoAtivo") boolean equipamentoAtivo, Pageable pageable);
	
	@Override
	public Optional<Equipamento> findById(Long id);
}
