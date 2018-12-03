package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemFolhaEntradaResponse;

public class FolhaEntradaResponse extends BasicFolhaResponse {

	private static final long serialVersionUID = 1L;

	public FolhaEntradaResponse(Folha folha) {
		super(folha);
	}

	public List<ItemFolhaEntradaResponse> getItens() {
		List<ItemFolhaEntradaResponse> itens = new ArrayList<>();
		if (Optional.ofNullable(folha).isPresent() && Optional.ofNullable(folha.getItens()).isPresent()) {
			for (Item item : folha.getItens()) {
				itens.add(new ItemFolhaEntradaResponse(item));
			}
		}
		return itens;
	}

}
