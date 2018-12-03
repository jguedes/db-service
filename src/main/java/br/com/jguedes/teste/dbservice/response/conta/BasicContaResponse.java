package br.com.jguedes.teste.dbservice.response.conta;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.jguedes.teste.dbservice.commons.Valuable;
import br.com.jguedes.teste.dbservice.entity.Conta;

public abstract class BasicContaResponse implements Serializable , Valuable {

	private static final long serialVersionUID = 1L;

	protected Conta conta;

	public BasicContaResponse(final Conta conta) {
		this.conta = conta;
	}

	public long getId() {
		return conta.getId();
	}

	public String getTitulo() {
		return conta.getTitulo();
	}

	public int getOrdem() {
		return conta.getOrdem();
	}

	@Override
	public BigDecimal getValor() {
		return conta.getValor();
	}
	
}
