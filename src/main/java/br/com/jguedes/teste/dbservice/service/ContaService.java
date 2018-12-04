package br.com.jguedes.teste.dbservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.repository.ContaRepository;
import br.com.jguedes.teste.dbservice.response.conta.ContaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContaSaidaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasEntradaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasEntradasAndSaidasResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContasSaidaResponse;

@Component
public class ContaService {

	@Autowired
	private ContaRepository rep;
	@Autowired
	private ItemService serviceItem;

	public List<ContaEntradaResponse> getContasEntradaByRelatorioMensalId(Long retorioId) {
		List<ContaEntradaResponse> contas = new ArrayList<>();
		for (Conta conta : rep.getContasByRelatorioMensalId(retorioId, TipoMovimentacao.ENTRADA)) {
			conta.setItens(serviceItem.getItensByRelatorioMensalIdAndContaId(retorioId, conta.getId()));
			contas.add(new ContaEntradaResponse(conta));
		}
		return contas;
	}

	public List<ContaSaidaResponse> getContasSaidaByRelatorioMensalId(Long retorioId) {
		List<ContaSaidaResponse> contas = new ArrayList<>();
		for (Conta conta : rep.getContasByRelatorioMensalId(retorioId, TipoMovimentacao.SAIDA)) {
			conta.setItens(serviceItem.getItensByRelatorioMensalIdAndContaId(retorioId, conta.getId()));
			contas.add(new ContaSaidaResponse(conta));
		}
		return contas;
	}

	public ContasEntradasAndSaidasResponse getAll() {
		return new ContasEntradasAndSaidasResponse(rep.findAll());
	}

	public ContasEntradaResponse getAllContasEntrada() {
		return new ContasEntradaResponse(rep.findByTipo(TipoMovimentacao.ENTRADA));
	}

	public ContasSaidaResponse getAllContasSaida() {
		return new ContasSaidaResponse(rep.findByTipo(TipoMovimentacao.SAIDA));
	}

	public ContaResponse getContaById(Long id) {
		return new ContaResponse(rep.findById(id).orElse(null));
	}

	public ContasEntradasAndSaidasResponse searchContasByTitulo(String texto) {
		return new ContasEntradasAndSaidasResponse(rep.findAll().stream()
				.filter(c -> c.getTitulo().toLowerCase().contains(texto.toLowerCase())).collect(Collectors.toList()));
	}

	public ContasEntradaResponse searchContasEntradaByTitulo(String texto) {
		return new ContasEntradaResponse(searchContasByTituloAndTipo(texto, TipoMovimentacao.ENTRADA));
	}

	public ContasSaidaResponse searchContasSaidaByTitulo(String texto) {
		return new ContasSaidaResponse(searchContasByTituloAndTipo(texto, TipoMovimentacao.SAIDA));
	}

	private List<Conta> searchContasByTituloAndTipo(String texto, char tipo) {
		return rep.findAll().stream()
				.filter(c -> c.getTipo() == tipo && c.getTitulo().toLowerCase().contains(texto.toLowerCase()))
				.collect(Collectors.toList());
	}

	public ContasEntradasAndSaidasResponse saveAndGetAll(Conta conta) {
		rep.save(conta);
		return getAll();
	}

}
