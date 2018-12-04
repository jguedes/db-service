package br.com.jguedes.teste.dbservice.response.conta;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jguedes.teste.dbservice.commons.Valuable;
import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.entity.Conta;

public class ContasEntradasAndSaidasResponse implements Valuable {
	
	private ContasEntradaResponse contasEntradas;
	private ContasSaidaResponse contasSaidas;
	
	public ContasEntradasAndSaidasResponse(List<Conta> contas) {
		contasEntradas = new ContasEntradaResponse(contas.stream().filter(c -> c.getTipo() == TipoMovimentacao.ENTRADA).collect(Collectors.toList()));
		contasSaidas = new ContasSaidaResponse(contas.stream().filter(c -> c.getTipo() == TipoMovimentacao.SAIDA).collect(Collectors.toList()));
	}
	
	public ContasEntradaResponse getContasEntradas() {
		return contasEntradas;
	}
	
	public ContasSaidaResponse getContasSaidas() {
		return contasSaidas;
	}
	
	@JsonProperty("saldo")
	@Override
	public BigDecimal getValor() {
		return contasEntradas.getValor().subtract(contasSaidas.getValor());
	}

}
