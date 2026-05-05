package eu.anembok.budget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
////
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "subcategory_id")
//    private Subcategory subcategory;
//
//    @ManyToOne
//    @JoinColumn(name = "place_id")
//    private Place place;
//

    private String description;

    private BigDecimal amountForeign;
    private BigDecimal exchangeRate;

}
