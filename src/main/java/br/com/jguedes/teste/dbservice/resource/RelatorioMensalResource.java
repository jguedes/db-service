package br.com.jguedes.teste.dbservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.response.relatorio.RelatorioMensalResponse;
import br.com.jguedes.teste.dbservice.response.relatorio.RelatoriosMensaisResponse;
import br.com.jguedes.teste.dbservice.service.RelatorioMensalService;

@RestController
@RequestMapping(value = "/rest/relatoriomensal")
public class RelatorioMensalResource {

	@Autowired
	private RelatorioMensalService service;

	@GetMapping(value = "/all")
	public RelatoriosMensaisResponse getAll() {
		return service.getAllListRelatorioMensalResponse();
	}

	@GetMapping(value = "/getRelatorioMensalById")
	public RelatorioMensalResponse getRelatorioMensalById(@RequestParam Long id) {
		return service.getRelatorioMensalById(id);
	}

	@GetMapping(value = "/getRelatoriosMensaisByAno")
	public RelatoriosMensaisResponse getRelatoriosMensaisByAno(@RequestParam final Integer ano) {
		return service.getListRelatorioMensalResponseByAno(ano);
	}

	@GetMapping(value = "/getRelatorioMensalByAnoAndMes")
	public RelatorioMensalResponse getRelatoriosMensaisByAnoAndMes(@RequestParam final Integer ano,
			@RequestParam final Integer mes) {
		return service.getRelatorioMensalResponseByAnoAndMes(ano, mes);
	}

	@PostMapping(value = "/save")
	public RelatoriosMensaisResponse persist(@RequestBody final RelatorioMensal relatorio) {
		return service.saveAndGetAll(relatorio);
	}

}
