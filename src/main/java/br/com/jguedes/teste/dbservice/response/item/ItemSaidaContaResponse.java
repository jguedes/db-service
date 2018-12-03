package br.com.jguedes.teste.dbservice.response.item;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemSaidaContaResponse extends ItemContaResponse {

	private static final long serialVersionUID = 1L;

	public ItemSaidaContaResponse(Item item) {
		super(item);
	}

	public String getComp() {
		return super.item.getComp();
	}

}
