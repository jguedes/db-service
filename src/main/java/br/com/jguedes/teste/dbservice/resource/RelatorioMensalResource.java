package br.com.jguedes.teste.dbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.repository.RelatorioMensalRepository;

@RestController
@RequestMapping(value="/rest/relatoriomensal")
public class RelatorioMensalResource {
	
	@Autowired
	private RelatorioMensalRepository relatorioMensalRepository;
	
	@GetMapping(value = "/all")
	public List<RelatorioMensal> getAll(){
		return relatorioMensalRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public List<RelatorioMensal> persist(@RequestBody final RelatorioMensal relatorio){
		relatorioMensalRepository.save(relatorio);
		return relatorioMensalRepository.findAll();
	}

}
