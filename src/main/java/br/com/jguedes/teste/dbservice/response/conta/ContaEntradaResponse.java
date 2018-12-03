package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemEntradaContaResponse;

public class ContaEntradaResponse extends BasicContaResponse {

	private static final long serialVersionUID = 1L;

	public ContaEntradaResponse(Conta conta) {
		super(conta);
	}

	public List<ItemEntradaContaResponse> getItens() {
		List<ItemEntradaContaResponse> itens = new ArrayList<>();
		for (Item item : conta.getItens()) {
			itens.add(new ItemEntradaContaResponse(item));
		}
		return itens;
	}

}
