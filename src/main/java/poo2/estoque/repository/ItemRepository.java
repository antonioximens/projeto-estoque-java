package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poo2.estoque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}