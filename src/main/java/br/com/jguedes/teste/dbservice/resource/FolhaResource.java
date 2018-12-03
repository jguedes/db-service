package br.com.jguedes.teste.dbservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.response.folha.FolhasResponse;
import br.com.jguedes.teste.dbservice.service.FolhaService;

@RestController
@RequestMapping(value="/rest/folha")
public class FolhaResource {
	
	@Autowired
	private FolhaService service;
	
	@GetMapping(value = "/all")
	public FolhasResponse getAll(){
		return service.getAllFolhas();
	}
	
	@PostMapping(value="/save")
	public FolhasResponse persist(@RequestBody final Folha folha){
		return service.saveAndGetAll(folha);
	}

}
