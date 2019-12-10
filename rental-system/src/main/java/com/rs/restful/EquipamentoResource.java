package com.rs.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.Equipamento;
import com.rs.service.EquipamentoService;

@Component
@RestController
@RequestMapping( "/api/equipamento" )
public class EquipamentoResource {
	
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@PostMapping("/insert")
	public Equipamento cadastrar( @RequestBody Equipamento equipamento ) {
		return this.equipamentoService.cadastrarEquipamento(equipamento);
	}
	
	@GetMapping("/list")
	public List<Equipamento> listar() {
		return this.equipamentoService.listarEquipamento();
	}
	
	@PostMapping("/update")
	public Equipamento atualizar( @RequestBody Equipamento equipamento ) {
		return this.equipamentoService.atualizarEquipamento(equipamento);
	}
	
	@GetMapping("/find")
	public Equipamento detalhar(@RequestParam("id") Long id) {
		return this.equipamentoService.detalharEquipamento(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.equipamentoService.removerEquipamento(id);
	}
}



