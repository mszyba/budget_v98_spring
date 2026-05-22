package eu.anembok.budget.controller;

import eu.anembok.budget.service.BankOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/bank-operations")
@RequiredArgsConstructor
public class BankOperationController {
    private final BankOperationService importService;

    @PostMapping("/import")
    public ResponseEntity<Void> importCsv(
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        importService.importCsv(file.getInputStream());

        return ResponseEntity.ok().build();
    }
}
