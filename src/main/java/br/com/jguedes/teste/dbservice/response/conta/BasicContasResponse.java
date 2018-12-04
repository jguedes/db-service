package br.com.jguedes.teste.dbservice.response.conta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jguedes.teste.dbservice.commons.Valuable;
import br.com.jguedes.teste.dbservice.entity.Conta;

public abstract class BasicContasResponse implements Valuable, Serializable {

	private static final long serialVersionUID = 1L;

	protected List<Conta> contas;

	public BasicContasResponse(List<Conta> contas) {
		this.contas = contas;
	}

	@JsonProperty("totalContas")
	@Override
	public BigDecimal getValor() {
		return contas.stream().map(Valuable::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
