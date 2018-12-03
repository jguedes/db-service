package br.com.jguedes.teste.dbservice.response.item;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemFolhaSaidaResponse extends ItemFolhaResponse {

	private static final long serialVersionUID = 1L;

	public ItemFolhaSaidaResponse(Item item) {
		super(item);
	}

	public String getComp() {
		return super.item.getComp();
	}

}
