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
import com.rs.service.LocacaoService;

@Component
@RestController
@RequestMapping( "/api/locacao" )
public class LocacaoResource {
	
	
	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private ItemLocacaoService itemLocacaoService;
	
	@PostMapping( "/insert" )
	public Locacao cadastrar( @RequestBody Locacao locacao ) {
		return this.locacaoService.cadastrarLocacao(locacao);
	}
	
	@GetMapping("/list")
	public List<Locacao> listar() {
		return this.locacaoService.listarLocacoes();
	}
	
	@GetMapping("/listInactive")
	public List<Locacao> listarInativas() {
		return this.locacaoService.listarLocacoesInativas();
	}
	
	@PostMapping( "/inactivate" )
	public Locacao inativar( @RequestBody Locacao locacao ) {
		return this.locacaoService.atualizarLocacao(locacao);
	}
}



