package com.rs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cliente extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@Column(unique = true, nullable = false, length = 20)
	@NotBlank
	private String cpf_cnpj;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private TipoEnum tipo;
	
	@NotBlank
	private String logradouro;

	@NotBlank
	private String numero;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String municipio;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String celular;
	
	@NotBlank
	private String email;
		
	private boolean clienteAtivo;
}
