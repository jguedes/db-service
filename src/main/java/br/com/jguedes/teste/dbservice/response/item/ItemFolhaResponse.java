package br.com.jguedes.teste.dbservice.response.item;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemFolhaResponse extends BasicItemResponse {

	private static final long serialVersionUID = 1L;

	public ItemFolhaResponse(Item item) {
		super(item);
	}

	public long getConta_id() {
		return item.getConta_id();
	}

}
