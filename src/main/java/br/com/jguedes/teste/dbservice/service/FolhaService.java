package br.com.jguedes.teste.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.repository.FolhaRepository;
import br.com.jguedes.teste.dbservice.response.folha.FolhasResponse;

@Component
public class FolhaService {

	@Autowired
	private FolhaRepository rep;

	public FolhasResponse getAllFolhas() {
		return new FolhasResponse(rep.findAll());
	}

	public FolhasResponse saveAndGetAll(Folha folha) {
		rep.save(folha);
		return getAllFolhas();
	}

}
