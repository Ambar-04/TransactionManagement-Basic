package ambar.transaction.SpringBoot.repository;

import ambar.transaction.SpringBoot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
