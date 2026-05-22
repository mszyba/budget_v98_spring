package eu.anembok.budget.controller;

import eu.anembok.budget.dto.TransactionDto;
import eu.anembok.budget.entity.Transaction;
import eu.anembok.budget.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin("http://localhost:8081")
@RestController
@AllArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/allOLD")
    public List<Transaction> getAllTransactions() {
        log.info("=====================================");


//        log.info(transactionService.getAllSort().stream().toList().toString());

        log.info("=====================================");
        return transactionService.getAllSort();
    }

    @GetMapping("/all")
    public List<TransactionDto> getAll() {
        log.info("----------------------------------------");


//        log.info(transactionService.getAllSort().stream().toList().toString());

        log.info("----------------------------------------");
        return transactionService.getAll();
    }



}
