package de.telekom.sea.mystuff.backend.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

	public Item() {
		this.id = null;
	}

	public Item(long id, String name, int amount, String location, String description, Date lastUsed) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.location = location;
		this.description = description;
		this.lastUsed = lastUsed;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;

	int amount;

	String location;

	String description;

	Date lastUsed;

}
