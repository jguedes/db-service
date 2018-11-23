package br.com.jguedes.teste.dbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.repository.ContaRepository;

@RestController
@RequestMapping(value="/rest/conta")
public class ContaResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping(value = "/all")
	public List<Conta> getAll(){
		return contaRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public List<Conta> persist(@RequestBody final Conta conta){
		contaRepository.save(conta);
		return contaRepository.findAll();
	}

}
