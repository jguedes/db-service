package br.com.jguedes.teste.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.repository.ItemRepository;
import br.com.jguedes.teste.dbservice.response.ItemResponseConta;

@Component
public class ItemService {

	@Autowired
	private ItemRepository rep;

	public List<ItemResponseConta> getItensByRelatorioMensalIdAndContaId(Long relatorioId, Long contaId) {
		List<Item> itens = rep.getItensByRelatorioIdAndContaId(relatorioId, contaId);
		List<ItemResponseConta> response = new ArrayList<>();
		for(Item item : itens) {
			response.add(new ItemResponseConta(item));
		}
		return response;
	}

}
