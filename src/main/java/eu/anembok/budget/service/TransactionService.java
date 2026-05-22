package eu.anembok.budget.service;

import eu.anembok.budget.dto.TransactionDto;
import eu.anembok.budget.entity.Transaction;
import eu.anembok.budget.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private Sort sortByIdAsc(){
        return Sort.by(Sort.Direction.ASC, "id");
    }

    public List<Transaction> getAllSort() {
        return transactionRepository.findAll(sortByIdAsc());
    }

    public List<TransactionDto> getAll() {
        return transactionRepository.findAll(sortByIdAsc())
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private TransactionDto mapToDto(Transaction t) {
        return new TransactionDto(
                t.getId(),
                t.getDate(),
                t.getAmount(),
                t.getType(),
                t.getCategory() != null
                        ? (int) t.getCategory().getId()
                        : null,
                t.getCategory() != null
                        ? t.getCategory().getName()
                        : null,
                t.getDescription(),
                t.getAmountForeign(),
                t.getExchangeRate()
        );
    }

    public Transaction getById(int id) { return transactionRepository.getReferenceById(id); }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void delete(int id) {
        Transaction transaction = getById(id);
        transactionRepository.delete(transaction);
    }
}
