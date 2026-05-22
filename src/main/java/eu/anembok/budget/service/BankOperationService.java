package eu.anembok.budget.service;

import eu.anembok.budget.repository.BankOperationRepository;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.MappingIterator;
import tools.jackson.dataformat.csv.CsvMapper;
import tools.jackson.dataformat.csv.CsvSchema;
import eu.anembok.budget.dto.BankOperationCsvDto;
import eu.anembok.budget.entity.BankOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankOperationService {

    private final BankOperationRepository bankOperationRepository;

    public void importCsv(InputStream inputStream) throws Exception {
        InputStream cleanCsv = cleanCsv(inputStream);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema()
                .withHeader()
                .withColumnSeparator(';')
                .withoutQuoteChar();

        MappingIterator<BankOperationCsvDto> iterator =
                mapper.readerFor(BankOperationCsvDto.class)
                        .with(schema)
                        .readValues(cleanCsv);

        List<BankOperation> operations = new ArrayList<>();


        while (iterator.hasNext()) {
            BankOperationCsvDto dto = iterator.next();
            log.info(dto.toString());
            operations.add(mapToEntity(dto));
        }

        log.info("Found {} operations", operations.size());
        bankOperationRepository.saveAll(operations);
    }

    private InputStream cleanCsv(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream)
        );

        String cleanedCsv = reader.lines()
                // usuwa końcowe ;; lub ;
                .map(line -> line.replaceAll(";+$", ""))
                .collect(Collectors.joining("\n"));

        return new ByteArrayInputStream(
                cleanedCsv.getBytes(StandardCharsets.UTF_8)
        );
    }

    private BankOperation mapToEntity(BankOperationCsvDto dto) {
        String dtoAmount;
        BankOperation bankOperation = new BankOperation();

        bankOperation.setOperationDate(
                LocalDate.parse(dto.getOperationDate())
        );

        String dtoDescription = dto.getDescription();
        dtoDescription = dtoDescription.replaceAll("\"", "");
        Pattern ws = Pattern.compile("\\s+", Pattern.UNICODE_CHARACTER_CLASS);
        dtoDescription = ws.matcher(dtoDescription).replaceAll(" ");

        bankOperation.setDescription(dtoDescription);


        bankOperation.setAccount(dto.getAccount().replace("\"", ""));
        bankOperation.setBankCategory(dto.getBankCategory().replace("\"", ""));


        int lengthStringAmount = dto.getAmount().length();

        dtoAmount = dto.getAmount().substring(0, lengthStringAmount - 3).trim();
        dtoAmount = dtoAmount.replaceAll(",", ".");
        dtoAmount = dtoAmount.replaceAll(" ", "");
        BigDecimal dtoAmountDecimal = new BigDecimal(dtoAmount);
        bankOperation.setAmount(dtoAmountDecimal);

        bankOperation.setCurrency(dto.getAmount().substring(lengthStringAmount - 3, lengthStringAmount).trim());

        return bankOperation;
    }

//    private void parseAmount(String value, BankOperation entity) {
//
//        if (value == null || value.isBlank()) {
//            return;
//        }
//
//        String cleaned = value.trim();
//
//        Currency currency = null;
//
//        if (cleaned.endsWith("PLN")) {
//            currency = Currency.PLN;
//            cleaned = cleaned.replace("PLN", "");
//        } else if (cleaned.endsWith("EUR")) {
//            currency = Currency.EUR;
//            cleaned = cleaned.replace("EUR", "");
//        } else if (cleaned.endsWith("USD")) {
//            currency = Currency.USD;
//            cleaned = cleaned.replace("USD", "");
//        }
//
//        cleaned = cleaned
//                .replace(" ", "")
//                .replace(",", ".");
//
//        entity.setAmountForeign(new BigDecimal(cleaned));
//
//        entity.setCurrency(currency);
//    }
}