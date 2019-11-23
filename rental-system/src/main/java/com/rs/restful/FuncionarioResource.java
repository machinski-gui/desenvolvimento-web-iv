package com.rs.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.Funcionario;
import com.rs.service.FuncionarioService;

@Component
@RestController
@RequestMapping( "/api/funcionario" )
public class FuncionarioResource {
	
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/list")
	public List<Funcionario> listar() {
		System.out.println("\n\n CHAMOU O METODO LISTAR \n\n");
		System.out.println(this.funcionarioService.listarFuncionarios());
		return this.funcionarioService.listarFuncionarios();
	}	
}



