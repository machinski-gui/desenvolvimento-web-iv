package com.rs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ItemLocacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Locacao locacao;
	
	@OneToOne
	private Equipamento equipamento;
	
	@NotNull
	private Integer quantidade;
	
	@NotNull
	private double valorUnitario;
}
