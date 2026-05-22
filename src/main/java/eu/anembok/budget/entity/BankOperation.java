package eu.anembok.budget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate operationDate;
    private String description;
    private String account;
    private String bankCategory;
    private BigDecimal amount;
    private String currency;
}