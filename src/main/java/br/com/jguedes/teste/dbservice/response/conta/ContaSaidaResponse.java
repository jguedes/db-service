package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemContaSaidaResponse;

public class ContaSaidaResponse extends BasicContaResponse {

	private static final long serialVersionUID = 1L;

	public ContaSaidaResponse(Conta conta) {
		super(conta);
	}

	public List<ItemContaSaidaResponse> getItens() {
		List<ItemContaSaidaResponse> itens = new ArrayList<>();
		for (Item item : conta.getItens()) {
			itens.add(new ItemContaSaidaResponse(item));
		}
		return itens;
	}

}
