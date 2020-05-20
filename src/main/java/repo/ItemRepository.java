package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
