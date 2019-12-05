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

import com.rs.entity.ItemLocacao;
import com.rs.entity.Locacao;
import com.rs.service.ItemLocacaoService;

@Component
@RestController
@RequestMapping( "/api/itemLocacao" )
public class ItemLocacaoResource {
		
	@Autowired
	private ItemLocacaoService itemLocacaoService;
	
	@PostMapping( "/insert" )
	public ItemLocacao cadastrar( @RequestBody ItemLocacao itemLocacao ) {
		return this.itemLocacaoService.cadastrarItemLocacao(itemLocacao);
	}
	
	@GetMapping("/list")
	public List<ItemLocacao> listar() {
		return this.itemLocacaoService.listarItemLocacao();
	}
	
	@GetMapping("/detail")
	public List<ItemLocacao> detalhar(@RequestParam("id") Long id) {
		return this.itemLocacaoService.detalharItemLocacao(id);
	}
}



