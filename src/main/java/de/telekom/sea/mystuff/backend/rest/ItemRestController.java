package de.telekom.sea.mystuff.backend.rest;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea.mystuff.backend.entities.Item;
import de.telekom.sea.mystuff.backend.repo.ItemRepository;

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

	@GetMapping("items/{id}")
	public ResponseEntity<Optional<Item>> getById(@PathVariable("id") Long id) {
		try {
			Optional<Item> item = repo.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(item);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("items")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Item saveItem(@RequestBody Item item) {
		return repo.save(item);
	}

	@PutMapping("items/{id}")
	public Item putItem(@RequestBody Item item) {
		return this.repo.save(item);
	}

	@DeleteMapping("items/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Item> deleteItem(@PathVariable Long id) {
		try {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
