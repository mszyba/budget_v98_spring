package eu.anembok.budget.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankOperationCsvDto {
    @JsonProperty("#Data operacji")
    private String operationDate;

    @JsonProperty("#Opis operacji")
    private String description;

    @JsonProperty("#Rachunek")
    private String account;

    @JsonProperty("#Kategoria")
    private String bankCategory;

    @JsonProperty("#Kwota")
    private String amount;

    @Override
    public String toString() {
        return "BankOperationCsvDto{" +
                "operationDate='" + operationDate + '\'' +
                ", description='" + description + '\'' +
                ", account='" + account + '\'' +
                ", bankCategory='" + bankCategory + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
