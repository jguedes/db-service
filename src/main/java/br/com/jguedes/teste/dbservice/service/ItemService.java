package br.com.jguedes.teste.dbservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.repository.ItemRepository;

@Component
public class ItemService {

	@Autowired
	private ItemRepository rep;

	public List<Item> getItensByRelatorioMensalIdAndContaId(Long relatorioId, Long contaId) {
		return rep.getItensByRelatorioIdAndContaId(relatorioId, contaId);
	}

}
