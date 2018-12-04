package br.com.jguedes.teste.dbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.response.item.ItemResponse;
import br.com.jguedes.teste.dbservice.service.ItemService;

@RestController
@RequestMapping(value = "/rest/item")
public class ItemResource {

	@Autowired
	private ItemService service;

	@GetMapping(value = "/all")
	public List<ItemResponse> getAll() {
		return service.getAll();
	}

	@PostMapping(value = "/save")
	public List<ItemResponse> persist(@RequestBody final Item item) {
		return service.saveAndGetAll(item);
	}

}
