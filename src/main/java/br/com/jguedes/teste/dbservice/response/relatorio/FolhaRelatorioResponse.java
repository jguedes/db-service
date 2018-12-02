package br.com.jguedes.teste.dbservice.response.relatorio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jguedes.teste.dbservice.entity.Folha;

public abstract class FolhaRelatorioResponse implements Serializable, Valuable {

	private static final long serialVersionUID = 1L;
	protected Folha folha;

	public FolhaRelatorioResponse(final Folha folha) {
		this.folha = folha;
	}

	public long getId() {
		return folha.getId();
	}

	public int getNum() {
		return folha.getNum();
	}

	public String getAssinatura1() {
		return folha.getAssinatura1();
	}

	public String getAssinatura2() {
		return folha.getAssinatura2();
	}

	public LocalDate getDtFechamento() {
		return folha.getDtFechamento();
	}

	public BigDecimal getTotalFolha() {
		return folha.getValor();
	}

	@JsonIgnore
	@Override
	public BigDecimal getValor() {
		return folha.getValor();
	}

}
