package br.com.jguedes.teste.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.repository.ItemRepository;
import br.com.jguedes.teste.dbservice.response.item.ItemResponse;

@Component
public class ItemService {

	@Autowired
	private ItemRepository rep;

	public List<Item> getItensByRelatorioMensalIdAndContaId(Long relatorioId, Long contaId) {
		return rep.getItensByRelatorioIdAndContaId(relatorioId, contaId);
	}

	public List<ItemResponse> getAll() {
		List<ItemResponse> itens = new ArrayList<>();
		for (Item item : rep.findAll()) {
			itens.add(new ItemResponse(item));
		}
		return itens;
	}

	public List<ItemResponse> saveAndGetAll(Item item) {
		rep.save(item);
		return getAll();
	}

}
