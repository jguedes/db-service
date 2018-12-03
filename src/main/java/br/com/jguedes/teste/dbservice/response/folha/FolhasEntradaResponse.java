package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Folha;

public class FolhasEntradaResponse extends BasicFolhasResponse {

	private static final long serialVersionUID = 1L;

	public FolhasEntradaResponse(List<Folha> folhas) {
		super(folhas);
	}

	public List<FolhaEntradaResponse> getFolhas() {
		List<FolhaEntradaResponse> retorno = new ArrayList<>();
		for (Folha folha : super.folhas) {
			retorno.add(new FolhaEntradaResponse(folha));
		}
		return retorno;
	}

}
