package br.com.jguedes.teste.dbservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.response.conta.ContaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasEntradaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasEntradasAndSaidasResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasSaidaResponse;
import br.com.jguedes.teste.dbservice.service.ContaService;

@RestController
@RequestMapping(value = "/rest/conta")
public class ContaResource {

	@Autowired
	private ContaService service;

	@GetMapping(value = "/all")
	public ContasEntradasAndSaidasResponse getAll() {
		return service.getAll();
	}

	@GetMapping(value = "/getAllContasEntrada")
	public ContasEntradaResponse getAllContasEntrada() {
		return service.getAllContasEntrada();
	}

	@GetMapping(value = "/getAllContasSaida")
	public ContasSaidaResponse getAllContasSaida() {
		return service.getAllContasSaida();
	}

	@GetMapping(value = "/getContaById")
	public ContaResponse getContaById(@RequestParam Long id) {
		return service.getContaById(id);
	}

	@GetMapping(value = "/searchContasByTitulo")
	public ContasEntradasAndSaidasResponse searchContasByTitulo(@RequestParam final String texto) {
		return service.searchContasByTitulo(texto);
	}

	@GetMapping(value = "/searchContasEntradaByTitulo")
	public ContasEntradaResponse searchContasEntradaByTitulo(@RequestParam final String texto) {
		return service.searchContasEntradaByTitulo(texto);
	}

	@GetMapping(value = "/searchContasSaidaByTitulo")
	public ContasSaidaResponse searchContasSaidaByTitulo(@RequestParam final String texto) {
		return service.searchContasSaidaByTitulo(texto);
	}

	@PostMapping(value = "/save")
	public ContasEntradasAndSaidasResponse persist(@RequestBody final Conta conta) {
		return service.saveAndGetAll(conta);
	}

}
