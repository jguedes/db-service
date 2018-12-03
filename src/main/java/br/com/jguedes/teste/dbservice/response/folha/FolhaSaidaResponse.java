package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemFolhaSaidaResponse;

public class FolhaSaidaResponse extends FolhaWithoutGetTipoResponse {

	private static final long serialVersionUID = 1L;

	public FolhaSaidaResponse(Folha folha) {
		super(folha);
	}

	public List<ItemFolhaSaidaResponse> getItens() {
		List<ItemFolhaSaidaResponse> itens = new ArrayList<>();
		if (Optional.ofNullable(folha).isPresent() && Optional.ofNullable(folha.getItens()).isPresent()) {
			for (Item item : folha.getItens()) {
				itens.add(new ItemFolhaSaidaResponse(item));
			}
		}
		return itens;
	}

}
