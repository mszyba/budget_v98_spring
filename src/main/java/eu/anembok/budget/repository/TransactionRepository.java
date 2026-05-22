package eu.anembok.budget.repository;

import eu.anembok.budget.dto.TransactionDto;
import eu.anembok.budget.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


}
