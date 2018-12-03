package br.com.jguedes.teste.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.repository.FolhaRepository;
import br.com.jguedes.teste.dbservice.response.folha.FullFolhasResponse;

@Component
public class FolhaService {

	@Autowired
	private FolhaRepository rep;

	public FullFolhasResponse getAllFolhas() {
		return new FullFolhasResponse(rep.findAll());
	}

	public FullFolhasResponse saveAndGetAll(Folha folha) {
		rep.save(folha);
		return getAllFolhas();
	}

}
