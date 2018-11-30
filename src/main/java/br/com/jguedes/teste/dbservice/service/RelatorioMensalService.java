package br.com.jguedes.teste.dbservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.repository.RelatorioMensalRepository;
import br.com.jguedes.teste.dbservice.response.RelatorioMensalResponse;
import br.com.jguedes.teste.dbservice.response.RelatoriosMensaisResponse;

@Component
public class RelatorioMensalService {

	@Autowired
	private RelatorioMensalRepository rep;
	
	public RelatoriosMensaisResponse getListRelatorioMensalResponse(Integer ano) {
		return getListRelatorioMensalResponse(
				rep.findAll().stream().filter(r -> r.getAno() == ano).collect(Collectors.toList()));
	}

	public RelatoriosMensaisResponse getListRelatorioMensalResponse(Integer ano, Integer mes) {
		return getListRelatorioMensalResponse(rep.findAll().stream().filter(r -> r.getAno() == ano && r.getMes() == mes)
				.collect(Collectors.toList()));
	}

	private RelatoriosMensaisResponse getListRelatorioMensalResponse(final List<RelatorioMensal> lista) {

		RelatoriosMensaisResponse retorno = new RelatoriosMensaisResponse();

		for (RelatorioMensal r : lista) {
			retorno.getRelatoriosMensais().add(getRelatorioMensalResponse(r));
		}

		return retorno;
	}

	private RelatorioMensalResponse getRelatorioMensalResponse(final RelatorioMensal relatorioMensal) {
		RelatorioMensalResponse rm = new RelatorioMensalResponse(relatorioMensal);
		return rm;
	}

}
