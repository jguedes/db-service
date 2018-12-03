package br.com.jguedes.teste.dbservice.response.folha;

import java.util.ArrayList;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Folha;

public class FolhasSaidaResponse extends BasicFolhasResponse {

	private static final long serialVersionUID = 1L;

	public FolhasSaidaResponse(List<Folha> folhas) {
		super(folhas);
	}

	public List<FolhaSaidaResponse> getFolhas() {
		List<FolhaSaidaResponse> retorno = new ArrayList<>();
		for (Folha folha : super.folhas) {
			retorno.add(new FolhaSaidaResponse(folha));
		}
		return retorno;
	}

}
