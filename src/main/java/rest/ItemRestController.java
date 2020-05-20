package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Item;
import repo.ItemRepository;

@RestController
@RequestMapping("/api/v1/")
public class ItemRestController {

	private final ItemRepository repo;

	@Autowired
	public ItemRestController(ItemRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("hi")
	public String hi() {
		return "Hi There, I'm here!";
	}
	
	@GetMapping("items")
	public List<Item> getAll() {
		return repo.findAll();
	}

}
