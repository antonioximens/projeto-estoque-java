package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poo2.estoque.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}