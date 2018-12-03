package br.com.jguedes.teste.dbservice.response.folha;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jguedes.teste.dbservice.commons.Valuable;
import br.com.jguedes.teste.dbservice.entity.Folha;

public abstract class Folhas implements Valuable, Serializable {

	private static final long serialVersionUID = 1L;

	protected List<Folha> folhas;

	public Folhas(List<Folha> folhas) {
		this.folhas = folhas;
	}

	@JsonProperty("valorTotal")
	@Override
	public BigDecimal getValor() {
		return folhas.stream().map(Valuable::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
