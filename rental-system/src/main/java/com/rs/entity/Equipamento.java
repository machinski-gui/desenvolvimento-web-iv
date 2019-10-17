package com.rs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Equipamento extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String codigo;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private double precoEquipamento;
	
	@NotBlank
	private double precoLocacao;
	
	@NotBlank
	private Integer estoque;
	
	private boolean equipamentoAtivo;
}
