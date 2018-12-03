package br.com.jguedes.teste.dbservice.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.repository.ContaRepository;
import br.com.jguedes.teste.dbservice.response.conta.ContaResponse;

@RestController
@RequestMapping(value = "/rest/conta")
public class ContaResource {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping(value = "/all")
	public List<ContaResponse> getAll() {
		return getListContaResponse(contaRepository.findAll());
	}

	@GetMapping(value = "/getContasEntrada")
	public List<ContaResponse> getContasEntrada() {
		return getListContaResponse(contaRepository
				.findAll()
				.stream()
				.filter(c -> c.getTipo() == 'e')
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/getContasSaida")
	public List<ContaResponse> getContasSaida(){
		return getListContaResponse(contaRepository
				.findAll()
				.stream()
				.filter(c -> c.getTipo() == 's')
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/getContaById")
	public Conta getContaById(@RequestParam Long id) {

		Optional<Conta> opt_conta = contaRepository.findById(id);

		return opt_conta.isPresent() ? opt_conta.get() : null;

	}

	@GetMapping(value = "/searchContasByTitulo")
	public List<Conta> searchContasByTitulo(@RequestParam final String texto) {
		return contaRepository
				.findAll()
				.stream()
				.filter(c -> c.getTitulo().toLowerCase().contains(texto.toLowerCase()))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/searchContasEntradaByTitulo")
	public List<Conta> searchContasEntradaByTitulo(@RequestParam final String texto) {
		return contaRepository.findAll()
				.stream()
				.filter(c -> c.getTipo() == 'e' && c.getTitulo().toLowerCase().contains(texto.toLowerCase()))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/searchContasSaidaByTitulo")
	public List<Conta> searchContasSaidaByTitulo(@RequestParam final String texto) {
		return contaRepository
				.findAll()
				.stream()
				.filter(c -> c.getTipo() == 's' && c.getTitulo().toLowerCase().contains(texto.toLowerCase()))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/save")
	public List<Conta> persist(@RequestBody final Conta conta) {
		contaRepository.save(conta);
		return contaRepository.findAll();
	}

	private List<ContaResponse> getListContaResponse(List<Conta> contas) {
		List<ContaResponse> retorno = new ArrayList<>();
		for (Conta c : contas) {
			retorno.add(getContaResponse(c));
		}
		return retorno;
	}

	private ContaResponse getContaResponse(Conta c) {
		return new ContaResponse(c);
	}

}
