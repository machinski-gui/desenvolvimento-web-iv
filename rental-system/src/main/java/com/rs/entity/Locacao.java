package com.rs.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Locacao extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private Funcionario funcionario;
	
	@NotNull
	private LocalDateTime dataEmprestimo;
	
	@NotNull
	private LocalDateTime dataDevolucao;
	
	@NotNull
	private double valorTotal;
	
	private boolean locacaoAtivo;
}
