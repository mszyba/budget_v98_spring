package eu.anembok.budget.csv;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.csv.CsvMapper;
import tools.jackson.dataformat.csv.CsvSchema;

public class CsvSchemaBankOperation {

    CsvSchema csvSchema = CsvSchema.builder()
            .addColumn("#Data operacji")
            .addColumn("#Opis operacji")
            .addColumn("#Rachunek")
            .addColumn("#Kategoria")
            .addColumn("#Kwota")
            .build();

}
