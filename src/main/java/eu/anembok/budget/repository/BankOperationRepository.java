package eu.anembok.budget.repository;

import eu.anembok.budget.entity.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankOperationRepository extends JpaRepository<BankOperation, Integer> {
}
