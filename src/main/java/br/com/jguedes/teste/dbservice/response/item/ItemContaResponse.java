package br.com.jguedes.teste.dbservice.response.item;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemContaResponse extends BasicItemResponse {

	private static final long serialVersionUID = 1L;

	public ItemContaResponse(Item item) {
		super(item);
	}

	public long getFolha_id() {
		return item.getFolha_id();
	}

}
