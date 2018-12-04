package br.com.jguedes.teste.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.repository.FolhaRepository;
import br.com.jguedes.teste.dbservice.response.folha.FolhaEntradaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhaSaidaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhasEntradaResponse;
import br.com.jguedes.teste.dbservice.response.folha.FolhasSaidaResponse;
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

	public FullFolhasResponse getFolhasByAno(Integer ano) {
		return new FullFolhasResponse(rep.findByAno(ano));
	}

	public FullFolhasResponse getFolhasByAnoAndMes(Integer ano, Integer mes) {
		return new FullFolhasResponse(rep.findByAnoAndMes(ano, mes));
	}

	public FolhasEntradaResponse getFolhasEntradaByAnoAndMes(Integer ano, Integer mes) {
		return new FolhasEntradaResponse(rep.getFolhasByAnoAndMesAndTipo(ano, mes, TipoMovimentacao.ENTRADA));
	}

	public FolhasSaidaResponse getFolhasSaidaByAnoAndMes(Integer ano, Integer mes) {
		return new FolhasSaidaResponse(rep.getFolhasByAnoAndMesAndTipo(ano, mes, TipoMovimentacao.SAIDA));
	}

	public FolhaEntradaResponse getFolhaEntradaByAnoAndMesAndTipoAndNum(Integer ano, Integer mes, Integer num) {
		return new FolhaEntradaResponse(rep.getFolhaByAnoAndMesAndTipoAndNum(ano, mes, TipoMovimentacao.ENTRADA, num));
	}

	public FolhaSaidaResponse getFolhaSaidaByAnoAndMesAndTipoAndNum(Integer ano, Integer mes, Integer num) {
		return new FolhaSaidaResponse(rep.getFolhaByAnoAndMesAndTipoAndNum(ano, mes, TipoMovimentacao.SAIDA, num));
	}

	public FolhaResponse getFolhaById(Long id) {
		return new FolhaResponse(rep.findById(id).orElse(null));
	}

}
