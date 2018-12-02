package br.com.jguedes.teste.dbservice.response.relatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;

public class FolhaEntradaRelatorioResponse extends FolhaRelatorioResponse {

	private static final long serialVersionUID = 1L;

	public FolhaEntradaRelatorioResponse(Folha folha) {
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
