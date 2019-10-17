package com.rs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column(unique = true, nullable = false, length = 11)
	private String cpf_cnpj;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Tipo tipo;
	
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
