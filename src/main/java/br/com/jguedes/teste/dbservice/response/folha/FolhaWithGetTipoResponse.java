package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemResponse;

public class FolhaWithGetTipoResponse extends FolhaWithoutGetTipoResponse {

	private static final long serialVersionUID = 1L;

	public FolhaWithGetTipoResponse(Folha folha) {
		super(folha);
	}

	public char getTipo() {
		return folha.getTipo();
	}

	public List<ItemResponse> getItens() {
		List<ItemResponse> itens = new ArrayList<>();
		if (Optional.ofNullable(folha).isPresent() && Optional.ofNullable(folha.getItens()).isPresent()) {
			for (Item item : folha.getItens()) {
				itens.add(new ItemResponse(item));
			}
		}
		return itens;
	}

}
