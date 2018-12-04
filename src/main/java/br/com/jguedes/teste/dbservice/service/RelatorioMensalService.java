package br.com.jguedes.teste.dbservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.commons.AnoMes;
import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;
import br.com.jguedes.teste.dbservice.repository.RelatorioMensalRepository;
import br.com.jguedes.teste.dbservice.response.relatorio.RelatorioMensalResponse;
import br.com.jguedes.teste.dbservice.response.relatorio.RelatoriosMensaisResponse;

@Component
public class RelatorioMensalService {

	@Autowired
	private RelatorioMensalRepository rep;
	@Autowired
	ContaService serviceConta;

	public RelatoriosMensaisResponse saveAndGetAll(RelatorioMensal relatorio) {
		rep.save(relatorio);
		return getAllListRelatorioMensalResponse();
	}

	public RelatoriosMensaisResponse getAllListRelatorioMensalResponse() {
		return getListRelatorioMensalResponse(rep.findAll());
	}

	public RelatoriosMensaisResponse getListRelatorioMensalResponseByAno(Integer ano) {
		return getListRelatorioMensalResponse(rep.findByAno(ano));
	}

	public RelatorioMensalResponse getRelatorioMensalResponseByAnoAndMes(Integer ano, Integer mes) {
		Optional<RelatorioMensal> opt_rel = rep.findByAnoAndMes(ano, mes);
		return opt_rel.isPresent() ? getRelatorioMensalResponse(opt_rel.get()) : null;
	}

	public RelatorioMensalResponse getRelatorioMensalById(Long id) {
		Optional<RelatorioMensal> opt_rel = rep.findById(id);
		return opt_rel.isPresent() ? getRelatorioMensalResponse(opt_rel.get()) : null;
	}

	private RelatoriosMensaisResponse getListRelatorioMensalResponse(final List<RelatorioMensal> lista) {

		RelatoriosMensaisResponse retorno = new RelatoriosMensaisResponse();

		for (RelatorioMensal r : lista) {
			retorno.getRelatoriosMensais().add(getRelatorioMensalResponse(r));
		}

		return retorno;
	}

	private RelatorioMensalResponse getRelatorioMensalResponse(final RelatorioMensal relatorioMensal) {
		AnoMes ama = new AnoMes(relatorioMensal.getAno(), relatorioMensal.getMes()).getAnoMesAnterior();
		relatorioMensal.setSaldoMesAnterior(rep.getSaldoRelatorioMensal(ama.getAno(), ama.getMes()));

		RelatorioMensalResponse rm = new RelatorioMensalResponse(relatorioMensal);
		rm.setContasEntrada(serviceConta.getContasEntradaByRelatorioMensalId(rm.getId()));
		rm.setContasSaida(serviceConta.getContasSaidaByRelatorioMensalId(rm.getId()));
		return rm;
	}

}