package br.com.jguedes.teste.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.repository.ContaRepository;
import br.com.jguedes.teste.dbservice.response.conta.ContaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContaSaidaResponse;

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

}
