package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;

public class ContasSaidaResponse extends BasicContasResponse {

	private static final long serialVersionUID = 1L;

	public ContasSaidaResponse(List<Conta> contas) {
		super(contas);
	}

	public List<ContaSaidaResponse> contas() {
		List<ContaSaidaResponse> contas = new ArrayList<>();
		for (Conta conta : super.contas) {
			contas.add(new ContaSaidaResponse(conta));
		}
		return contas;
	}

}
