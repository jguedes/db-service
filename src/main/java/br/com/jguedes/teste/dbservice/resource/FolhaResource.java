package br.com.jguedes.teste.dbservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.response.folha.FolhaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaSaidaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhasEntradaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhasSaidaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FullFolhasResponse;
import br.com.jguedes.teste.dbservice.service.FolhaService;

@RestController
@RequestMapping(value = "/rest/folha")
public class FolhaResource {

	@Autowired
	private FolhaService service;

	@GetMapping(value = "/all")
	public FullFolhasResponse getAll() {
		return service.getAllFolhas();
	}

	@GetMapping(value = "/getFolhasByAno")
	public FullFolhasResponse getFolhasByAno(@RequestParam final Integer ano) {
		return service.getFolhasByAno(ano);
	}

	@GetMapping(value = "/getFolhasByAnoAndMes")
	public FullFolhasResponse getFolhasByAnoAndMes(@RequestParam final Integer ano, @RequestParam final Integer mes) {
		return service.getFolhasByAnoAndMes(ano, mes);
	}

	@GetMapping(value = "/getFolhasEntradaByAnoAndMes")
	public FolhasEntradaResponse getFolhasEntradaByAnoAndMes(@RequestParam final Integer ano,
			@RequestParam final Integer mes) {
		return service.getFolhasEntradaByAnoAndMes(ano, mes);
	}

	@GetMapping(value = "/getFolhasSaidaByAnoAndMes")
	public FolhasSaidaResponse getFolhasSaidaByAnoAndMes(@RequestParam final Integer ano,
			@RequestParam final Integer mes) {
		return service.getFolhasSaidaByAnoAndMes(ano, mes);
	}

	@GetMapping(value = "/getFolhaEntradaByAnoAndMesAndNum")
	public FolhaEntradaResponse getFolhaEntradaByAnoAndMesAndNum(@RequestParam final Integer ano, @RequestParam final Integer mes,@RequestParam final Integer num) {
		return service.getFolhaEntradaByAnoAndMesAndTipoAndNum(ano, mes,num);
	}

	@GetMapping(value = "/getFolhaSaidaByAnoAndMesAndNum")
	public FolhaSaidaResponse getFolhaSaidaByAnoAndMesAndNum(@RequestParam final Integer ano, @RequestParam final Integer mes,@RequestParam final Integer num) {
		return service.getFolhaSaidaByAnoAndMesAndTipoAndNum(ano, mes,num);
	}

	@GetMapping(value = "/getFolhaById")
	public FolhaResponse getFolhaById(@RequestParam final Long id) {
		return service.getFolhaById(id);
	}

	@PostMapping(value = "/save")
	public FullFolhasResponse persist(@RequestBody final Folha folha) {
		return service.saveAndGetAll(folha);
	}

}
