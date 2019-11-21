package com.rs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rs.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("FROM Cliente cliente ORDER BY cliente.nome ASC")
	public Page<Cliente> findOrdemAlfabetica(@Param("nome") String nome, @Param("cpf_cnpj") String cpf_cnpj, @Param("tipo") String tipo, @Param("logradouro") String logradouro, @Param("numero") String numero, @Param("bairro") String bairro, @Param("municipio") String municipio, @Param("estado") String estado, @Param("cep") String cep, @Param("telefone") String telefone, @Param("celular") String celular, @Param("email") String email, @Param("cliente_ativo") boolean cliente_ativo, Pageable pageable);
	
	@Query("FROM Cliente cliente WHERE cliente.clienteAtivo = true")
	public Page<Cliente> findClienteAtivo(@Param("nome") String nome, @Param("cpf_cnpj") String cpf_cnpj, @Param("tipo") String tipo, @Param("logradouro") String logradouro, @Param("numero") String numero, @Param("bairro") String bairro, @Param("municipio") String municipio, @Param("estado") String estado, @Param("cep") String cep, @Param("telefone") String telefone, @Param("celular") String celular, @Param("email") String email, @Param("cliente_ativo") boolean cliente_ativo, Pageable pageable);
	
	@Query("FROM Cliente cliente WHERE cliente.clienteAtivo = false")
	public Page<Cliente> findClienteInativo(@Param("nome") String nome, @Param("cpf_cnpj") String cpf_cnpj, @Param("tipo") String tipo, @Param("logradouro") String logradouro, @Param("numero") String numero, @Param("bairro") String bairro, @Param("municipio") String municipio, @Param("estado") String estado, @Param("cep") String cep, @Param("telefone") String telefone, @Param("celular") String celular, @Param("email") String email, @Param("cliente_ativo") boolean cliente_ativo, Pageable pageable);
}