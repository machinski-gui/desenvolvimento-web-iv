package com.rs.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.Equipamento;
import com.rs.service.EquipamentoService;

@Component
@RestController
@RequestMapping( "/api/equipamento" )
public class EquipamentoResource {
	
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@GetMapping("/list")
	public List<Equipamento> listar() {
		return this.equipamentoService.listarEquipamento();
	}	
}



