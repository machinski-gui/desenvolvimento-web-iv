package com.rs.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rs.entity.Cliente;
import com.rs.entity.Funcionario;
import com.rs.entity.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	@Query("FROM Locacao locacao ORDER BY locacao.valorTotal DESC")
	public Page<Locacao> findLocacaoPorValorTotal(@Param("cliente") Cliente cliente, @Param("funcionario") Funcionario funcionario, @Param("dataEmprestimo") LocalDateTime dataEmprestimo, @Param("dataDevolucao") LocalDateTime dataDevolucao, @Param("valorTotal") double valorTotal, @Param("locacaoAtivo") boolean locacaoAtivo, Pageable pageable);
	
	@Query("FROM Locacao locacao ORDER BY locacao.dataDevolucao ASC")
	public Page<Locacao> findLocacaoMaisRecente(@Param("cliente") Cliente cliente, @Param("funcionario") Funcionario funcionario, @Param("dataEmprestimo") LocalDateTime dataEmprestimo, @Param("dataDevolucao") LocalDateTime dataDevolucao, @Param("valorTotal") double valorTotal, @Param("locacaoAtivo") boolean locacaoAtivo, Pageable pageable);
	
	@Query("FROM Locacao locacao ORDER BY locacao.dataDevolucao DESC")
	public Page<Locacao> findLocacaoMaisAntiga(@Param("cliente") Cliente cliente, @Param("funcionario") Funcionario funcionario, @Param("dataEmprestimo") LocalDateTime dataEmprestimo, @Param("dataDevolucao") LocalDateTime dataDevolucao, @Param("valorTotal") double valorTotal, @Param("locacaoAtivo") boolean locacaoAtivo, Pageable pageable);
}
