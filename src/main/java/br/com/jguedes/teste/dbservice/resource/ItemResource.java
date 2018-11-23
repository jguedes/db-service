package br.com.jguedes.teste.dbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jguedes.teste.dbservice.entity.Item;
import br.com.jguedes.teste.dbservice.repository.ItemRepository;

@RestController
@RequestMapping(value="/rest/item")
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping(value = "/all")
	public List<Item> getAll(){
		return itemRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public List<Item> persist(@RequestBody final Item item){
		itemRepository.save(item);
		return itemRepository.findAll();
	}

}
