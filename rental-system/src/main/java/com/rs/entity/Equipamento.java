package com.rs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class Equipamento extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String codigo;
	
	@NotBlank
	private String descricao;
	
	private double precoEquipamento;
	
	private double precoLocacao;
	
	private Integer estoque;
	
	private boolean equipamentoAtivo;
}
