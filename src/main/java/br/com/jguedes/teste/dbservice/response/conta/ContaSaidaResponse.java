package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemSaidaContaResponse;

public class ContaSaidaResponse extends BasicContaResponse {

	private static final long serialVersionUID = 1L;

	public ContaSaidaResponse(Conta conta) {
		super(conta);
	}

	public List<ItemSaidaContaResponse> getItens() {
		List<ItemSaidaContaResponse> itens = new ArrayList<>();
		for (Item item : conta.getItens()) {
			itens.add(new ItemSaidaContaResponse(item));
		}
		return itens;
	}

}
