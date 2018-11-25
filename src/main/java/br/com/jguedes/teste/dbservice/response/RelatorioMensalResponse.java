package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;

public class RelatorioMensalResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private RelatorioMensal relatorioMensal;

	private List<FolhaResponse> folhasEntrada;

	private List<FolhaResponse> folhasSaida;

	public RelatorioMensalResponse(final RelatorioMensal relatorioMensal) {
		this.relatorioMensal = relatorioMensal;
		carrgarFolhasResponse();
	}

	private void carrgarFolhasResponse() {
		folhasEntrada = getFolhasByTipo('e');
		folhasSaida = getFolhasByTipo('s');
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

	public List<FolhaResponse> getFolhasEntrada() {
		return folhasEntrada;
	}

	public List<FolhaResponse> getFolhasSaida() {
		return folhasSaida;
	}
	
	public List<ContaResponse> getContasEntrada(){
		return null;
	}

	public BigDecimal getEntradaMes() {
		return getTotalMesByTipo('e');
	}

	public BigDecimal getSaidaMes() {
		return getTotalMesByTipo('s');
	}

	public BigDecimal getSaldoMes() {
		return getEntradaMes().subtract(getSaidaMes());
	}

	private List<FolhaResponse> getFolhasByTipo(char tipo) {
		if (tipo == 'e' && Optional.ofNullable(folhasEntrada).isPresent()) {
			return folhasEntrada;
		}
		if (tipo == 's' && Optional.ofNullable(folhasSaida).isPresent()) {
			return folhasSaida;
		}
		return getListFolhasResponse(
				relatorioMensal.getFolhas().stream().filter(f -> f.getTipo() == tipo).collect(Collectors.toList()));
	}

	private List<FolhaResponse> getListFolhasResponse(List<Folha> folhas) {
		List<FolhaResponse> retorno = new ArrayList<>();
		for (Folha f : folhas) {
			retorno.add(getFolhaResponse(f));
		}
		return retorno;
	}

	private FolhaResponse getFolhaResponse(Folha f) {
		return new FolhaResponse(f);
	}

	private BigDecimal getTotalMesByTipo(char tipo) {
		BigDecimal total = getFolhasByTipo(tipo).stream().map(FolhaResponse::getTotalFolha).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return total.setScale(2, RoundingMode.HALF_EVEN);
	}

}
