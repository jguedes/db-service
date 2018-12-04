package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemFolhaResponse;

public class FolhaResponse extends BasicFolhaResponse {

	private static final long serialVersionUID = 1L;

	public FolhaResponse(Folha folha) {
		super(folha);
	}
	
	public Long getRelatorioMensalId(){
		return folha.getRelatorio_mensal_id();
	}

	public char getTipo() {
		return folha.getTipo();
	}

	public List<ItemFolhaResponse> getItens() {
		List<ItemFolhaResponse> itens = new ArrayList<>();
		if (Optional.ofNullable(folha).isPresent() && Optional.ofNullable(folha.getItens()).isPresent()) {
			for (Item item : folha.getItens()) {
				itens.add(new ItemFolhaResponse(item));
			}
		}
		return itens;
	}

}
