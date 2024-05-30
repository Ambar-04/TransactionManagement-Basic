package ambar.transaction.SpringBoot.repository;

import ambar.transaction.SpringBoot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
