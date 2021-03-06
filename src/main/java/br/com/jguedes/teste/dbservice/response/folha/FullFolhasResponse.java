package br.com.jguedes.teste.dbservice.response.folha;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.entity.Folha;

public class FullFolhasResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FolhasEntradaResponse folhasEntrada;
	private FolhasSaidaResponse folhasSaida;

	public FullFolhasResponse(List<Folha> folhas) {
		setFolhasEntrada(new FolhasEntradaResponse(
				folhas.stream().filter(f -> f.getTipo() == TipoMovimentacao.ENTRADA).collect(Collectors.toList())));
		setFolhasSaida(new FolhasSaidaResponse(
				folhas.stream().filter(f -> f.getTipo() == TipoMovimentacao.SAIDA).collect(Collectors.toList())));
	}

	public FolhasEntradaResponse getFolhasEntrada() {
		return folhasEntrada;
	}

	private void setFolhasEntrada(FolhasEntradaResponse folhasEntrada) {
		this.folhasEntrada = folhasEntrada;
	}

	public FolhasSaidaResponse getFolhasSaida() {
		return folhasSaida;
	}

	private void setFolhasSaida(FolhasSaidaResponse folhasSaida) {
		this.folhasSaida = folhasSaida;
	}

}
