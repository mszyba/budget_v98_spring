package eu.anembok.budget.dto;

import eu.anembok.budget.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private int id;
    private LocalDate date;
    private BigDecimal amount;
    private TransactionType type;
    private Integer categoryId;
    private String categoryName;
    private String description;
    private BigDecimal amountForeign;
    private BigDecimal exchangeRate;

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", amountForeign=" + amountForeign +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
