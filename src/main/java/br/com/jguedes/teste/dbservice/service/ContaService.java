package br.com.jguedes.teste.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.repository.ContaRepository;
import br.com.jguedes.teste.dbservice.response.relatorio.ContaRelatorioResponse;

@Component
public class ContaService {

	@Autowired
	private ContaRepository rep;
	@Autowired
	private ItemService serviceItem;

	public List<ContaRelatorioResponse> getContaByRelatorioMensalIdAndTipo(Long retorioId, char tipo) {
		List<Conta> contas = rep.getContasByRelatorioMensalId(retorioId, tipo);
		List<ContaRelatorioResponse> response = new ArrayList<>();
		for (Conta c : contas) {
			ContaRelatorioResponse cr = new ContaRelatorioResponse(c);
			cr.setItens(serviceItem.getItensByRelatorioMensalIdAndContaId(retorioId,cr.getId()));
			response.add(cr);
		}
		return response;
	}

}
