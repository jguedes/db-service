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

public class RelatorioMensalResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private RelatorioMensal relatorioMensal;

	private List<ContaRelatorioResponse> contasEntrada;
	private List<ContaRelatorioResponse> contasSaida;

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

	public List<FolhaEntradaRelatorioResponse> getFolhasEntrada() {
		List<FolhaEntradaRelatorioResponse> folhas = new ArrayList<>();
		for (Folha f : relatorioMensal.getFolhasEntrada()) {
			folhas.add(new FolhaEntradaRelatorioResponse(f));
		}
		return folhas;
	}

	public List<FolhaSaidaRelatorioResponse> getFolhasSaida() {
		List<FolhaSaidaRelatorioResponse> folhas = new ArrayList<>();
		for (Folha f : relatorioMensal.getFolhasSaida()) {
			folhas.add(new FolhaSaidaRelatorioResponse(f));
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

	public List<ContaRelatorioResponse> getContasSaida() {
		return contasSaida;
	}

	public void setContasSaida(List<ContaRelatorioResponse> contasSaida) {
		this.contasSaida = contasSaida;
	}

	public void setContasEntrada(List<ContaRelatorioResponse> contasEntrada) {
		this.contasEntrada = contasEntrada;
	}

	public List<ContaRelatorioResponse> getContasEntrada() {
		return contasEntrada;
	}

}
