package br.com.jguedes.teste.dbservice.response.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemContaResponse;

public class ContaResponse extends BasicContaResponse {

	private static final long serialVersionUID = 1L;

	public ContaResponse(Conta conta) {
		super(conta);
	}

	public char getTipo() {
		return conta.getTipo();
	}

	public String getDescricao() {
		return conta.getDescricao();
	}

	public List<ItemContaResponse> getItens() {
		List<ItemContaResponse> itens = new ArrayList<>();
		for (Item item : conta.getItens()) {
			itens.add(new ItemContaResponse(item));
		}
		return itens;
	}

}
