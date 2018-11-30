package br.com.jguedes.teste.dbservice.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.repository.RelatorioMensalRepository;
import br.com.jguedes.teste.dbservice.response.RelatorioMensalResponse;
import br.com.jguedes.teste.dbservice.response.RelatoriosMensaisResponse;
import br.com.jguedes.teste.dbservice.service.RelatorioMensalService;

@RestController
@RequestMapping(value = "/rest/relatoriomensal")
public class RelatorioMensalResource {

	@Autowired
	private RelatorioMensalRepository rep;

	@Autowired
	private RelatorioMensalService service;

	@GetMapping(value = "/all")
	public List<RelatorioMensalResponse> getAll() {
		return getListRelatorioMensalResponse(rep.findAll());
	}

	@GetMapping(value = "/getRelatorioMensalById")
	public RelatorioMensalResponse getRelatorioMensalById(@RequestParam Long id) {
		Optional<RelatorioMensal> opt_rel = rep.findById(id);
		return opt_rel.isPresent() ? getRelatorioMensalResponse(opt_rel.get()) : null;
	}

	@GetMapping(value = "/getRelatoriosMensaisByAno")
	public RelatoriosMensaisResponse getRelatoriosMensaisByAno(@RequestParam final Integer ano) {
		return service.getListRelatorioMensalResponse(ano);
	}

	@GetMapping(value = "/getRelatorioMensalByAnoAndMes")
	public RelatoriosMensaisResponse getRelatoriosMensaisByAno(@RequestParam final Integer ano,
			@RequestParam final Integer mes) {
		return service.getListRelatorioMensalResponse(ano, mes);
	}

	@PostMapping(value = "/save")
	public List<RelatorioMensalResponse> persist(@RequestBody final RelatorioMensal relatorio) {
		rep.save(relatorio);
		return getListRelatorioMensalResponse(rep.findAll());
	}

	private List<RelatorioMensalResponse> getListRelatorioMensalResponse(final List<RelatorioMensal> lista) {

		List<RelatorioMensalResponse> retorno = new ArrayList<>();

		for (RelatorioMensal r : lista) {
			retorno.add(getRelatorioMensalResponse(r));
		}

		return retorno;
	}

	private RelatorioMensalResponse getRelatorioMensalResponse(final RelatorioMensal relatorioMensal) {
		RelatorioMensalResponse rm = new RelatorioMensalResponse(relatorioMensal);

		return rm;
	}

}
