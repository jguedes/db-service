package br.com.jguedes.teste.dbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.repository.FolhaRepository;

@RestController
@RequestMapping(value="/rest/folha")
public class FolhaResource {
	
	@Autowired
	private FolhaRepository folhaRepository;
	
	@GetMapping(value = "/all")
	public List<Folha> getAll(){
		return folhaRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public List<Folha> persist(@RequestBody final Folha folha){
		folhaRepository.save(folha);
		return folhaRepository.findAll();
	}

}
