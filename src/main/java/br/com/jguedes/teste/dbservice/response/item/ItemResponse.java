package br.com.jguedes.teste.dbservice.response.item;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemResponse extends BasicItemResponse {

	private static final long serialVersionUID = 1L;

	public ItemResponse(final Item item) {
		super(item);
	}

	public long getFolha_id() {
		return item.getFolha_id();
	}

	public long getConta_id() {
		return item.getConta_id();
	}

	public String getComp() {
		return item.getComp();
	}

}
