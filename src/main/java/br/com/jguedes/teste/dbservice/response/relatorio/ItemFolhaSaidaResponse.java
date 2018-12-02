package br.com.jguedes.teste.dbservice.response.relatorio;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemFolhaSaidaResponse extends ItemFolhaEntradaResponse {

	private static final long serialVersionUID = 1L;

	public ItemFolhaSaidaResponse(Item item) {
		super(item);
	}

	public String getComp() {
		return super.item.getComp();
	}

}
