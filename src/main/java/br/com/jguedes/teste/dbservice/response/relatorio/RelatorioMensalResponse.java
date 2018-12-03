package br.com.jguedes.teste.dbservice.response.relatorio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.response.conta.ContaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.conta.ContaSaidaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaSaidaResponse;

public class RelatorioMensalResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private RelatorioMensal relatorioMensal;

	private List<ContaEntradaResponse> contasEntrada;
	private List<ContaSaidaResponse> contasSaida;

	public RelatorioMensalResponse(final RelatorioMensal relatorioMensal) {
		this.relatorioMensal = relatorioMensal;
	}

	public long getId() {
		return relatorioMensal.getId();
	}

	public int getAno() {
		return relatorioMensal.getAno();
	}

	public int getMes() {
		return relatorioMensal.getMes();
	}

	public LocalDate getDtFechamento() {
		return relatorioMensal.getDtFechamento();
	}

	public List<FolhaEntradaResponse> getFolhasEntrada() {
		List<FolhaEntradaResponse> folhas = new ArrayList<>();
		for (Folha f : relatorioMensal.getFolhasEntrada()) {
			folhas.add(new FolhaEntradaResponse(f));
		}
		return folhas;
	}

	public List<FolhaSaidaResponse> getFolhasSaida() {
		List<FolhaSaidaResponse> folhas = new ArrayList<>();
		for (Folha f : relatorioMensal.getFolhasSaida()) {
			folhas.add(new FolhaSaidaResponse(f));
		}
		return folhas;
	}

	public BigDecimal getEntradaMes() {
		return relatorioMensal.getEntradaMes().setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getSaidaMes() {
		return relatorioMensal.getSaidaMes().setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getSaldoMes() {
		return relatorioMensal.getSaldoMes().setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getSaldoMesAnterior() {
		return relatorioMensal.getSaldoMesAnterior().setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public BigDecimal getSaldoEmCaixa() {
		return relatorioMensal.getSaldoEmCaixa().setScale(2, RoundingMode.HALF_EVEN);
	}

	public List<ContaSaidaResponse> getContasSaida() {
		return contasSaida;
	}

	public void setContasSaida(List<ContaSaidaResponse> contasSaida) {
		this.contasSaida = contasSaida;
	}

	public void setContasEntrada(List<ContaEntradaResponse> contasEntrada) {
		this.contasEntrada = contasEntrada;
	}

	public List<ContaEntradaResponse> getContasEntrada() {
		return contasEntrada;
	}

}
