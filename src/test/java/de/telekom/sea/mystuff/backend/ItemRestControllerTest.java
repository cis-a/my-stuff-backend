package de.telekom.sea.mystuff.backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.telekom.sea.mystuff.backend.entities.Item;
import de.telekom.sea.mystuff.backend.repo.ItemRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemRestControllerTest {

	private static final String BASE_PATH = "/api/v1/items";

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ItemRepository repo;

	@BeforeEach
	void setupRepo() {
		repo.deleteAll();
	}

	@Test
	void shouldBeAbleToUploadAnItem() throws ParseException {
		// Given | Arrange
		Item lawnMower = buildLawnMower();
		// When | Act
		ResponseEntity<Item> response = restTemplate.postForEntity(BASE_PATH, lawnMower, Item.class);
		// Then | Assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody().getId()).isNotNull();
	}

	@Test
	void shouldReadAllItems() {
		// Given | Arrange
		// When | Act
		// Then | Assert
		fail("Not yet implemented");
	}

	@Test
	void shouldFindOneItem() throws ParseException {
		// Given | Arrange
		Item lawnMower = givenAnInsertedItem().getBody();
		// When | Act
		ResponseEntity<Item> response = restTemplate.getForEntity(BASE_PATH + "/" + lawnMower.getId(), Item.class);
		// Then | Assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualToComparingFieldByField(lawnMower);
		
	}

	@Test
	void shouldFindNoItemForUnknownId() throws URISyntaxException {
		fail();
	}

	@Test
	void shouldBeAbleToDeleteAnItem() throws URISyntaxException {
		fail();
	}

	@Test
	void shouldNotBeAbleToDeleteAnItemWithUnknownId() throws URISyntaxException {
		fail();
	}

	@Test
	void shouldBeAbleToReplaceAnItem() throws URISyntaxException {
		fail();
	}

	@Test
	void shouldNotBeAbleToReplaceAnItemWithUnknownId() throws URISyntaxException {
		fail();
	}

	private ResponseEntity<Item> givenAnInsertedItem() throws ParseException {
		Item item = buildLawnMower();
		return restTemplate.postForEntity(BASE_PATH, item, Item.class);
	}

	private Item buildLawnMower() throws ParseException {
		Item item = Item.builder().name("Lawn mower").amount(1).lastUsed(createDate("2019-05-01"))
				.location("Basement").build();
		return item;
	}

	private Item buildLawnTrimmer() throws ParseException {
		Item item = Item.builder().name("Lawn trimmer").amount(1).lastUsed(createDate("2018-05-01"))
				.location("Basement").build();
		return item;
	}

	private Date createDate (String dateInString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(dateInString);
	}
}