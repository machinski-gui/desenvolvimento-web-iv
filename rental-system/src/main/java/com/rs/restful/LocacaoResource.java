package com.rs.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.entity.ItemLocacao;
import com.rs.entity.Locacao;
import com.rs.service.ItemLocacaoService;
import com.rs.service.LocacaoService;

@Component
@RestController
@RequestMapping( "/api/locacao" )
public class LocacaoResource {
	
	
	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private ItemLocacaoService itemLocacaoService;
	
	@GetMapping("/list")
	public List<Locacao> listar() {
		return this.locacaoService.listarLocacoes();
	}
	
	@GetMapping("/detail")
	public List<ItemLocacao> detalhar(@RequestParam("id") Long id) {
		return this.itemLocacaoService.detalharItemLocacao(id);
	}
}



