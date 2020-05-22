package de.telekom.sea.mystuff.backend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.telekom.sea.mystuff.backend.entities.Item;
import de.telekom.sea.mystuff.backend.repo.ItemRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ItemRepository repo;
	
	@Autowired
	public void SetItemRepository (ItemRepository repo) {
		this.repo = repo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.initData();
	}

	private void initData() {

		Item teapot = new Item(1L, "Teapot", 1, "to left of door, top shelf, brown paper box",
				"HTTP 418: white porcelain with orange flowers", null);
		this.repo.save(teapot);

		Item mug = new Item(2L, "Coffee mug", 1, "to left of door, middle shelf, bubble wrapped",
				"white mug with SEA2.0 logo", null);
		this.repo.save(mug);
		
		Item socks = new Item(3L, "Coding socks", 1, "hanger on wall opposite of door, eye-level",
				"socks in beige and orange with WildCodeSchool logo", null);
		this.repo.save(socks);
				
	}
}
