package br.com.jguedes.teste.dbservice.response.relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosMensaisResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RelatorioMensalResponse> relatoriosMensais;

	public RelatoriosMensaisResponse() {
		relatoriosMensais = new ArrayList<>();
	}

	public List<RelatorioMensalResponse> getRelatoriosMensais() {
		return relatoriosMensais;
	}

	public void setRelatoriosMensais(List<RelatorioMensalResponse> relatoriosMensais) {
		this.relatoriosMensais = relatoriosMensais;
	}

}
