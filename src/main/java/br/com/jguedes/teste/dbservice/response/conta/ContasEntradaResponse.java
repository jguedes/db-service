package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;

public class ContasEntradaResponse extends BasicContasResponse {

	private static final long serialVersionUID = 1L;

	public ContasEntradaResponse(List<Conta> contas) {
		super(contas);
	}
	
	public List<ContaEntradaResponse> contas(){
		List<ContaEntradaResponse> contas = new ArrayList<>();
		for (Conta conta : super.contas){
			contas.add(new ContaEntradaResponse(conta));
		}
		return contas;
	}

}
