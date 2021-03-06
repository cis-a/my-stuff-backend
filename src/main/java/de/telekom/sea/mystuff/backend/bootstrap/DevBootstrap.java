package de.telekom.sea.mystuff.backend.bootstrap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void SetItemRepository(ItemRepository repo) {
		this.repo = repo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			this.initData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void initData() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
 
		String dateInString = "22-05-2020";
		Date date = formatter.parse(dateInString);

		Item teapot = new Item(1L, "Teapot", 1, "to left of door, top shelf, brown paper box",
				"HTTP 418: white porcelain with orange flowers", date);
		this.repo.save(teapot);

		Item mug = new Item(2L, "Coffee mug", 1, "to left of door, middle shelf, bubble wrapped",
				"white mug with SEA2.0 logo", date);
		this.repo.save(mug);

		Item socks = new Item(3L, "Coding socks", 1, "hanger on wall opposite of door, eye-level",
				"socks in beige and orange with WildCodeSchool logo", null);
		this.repo.save(socks);

	}
}
