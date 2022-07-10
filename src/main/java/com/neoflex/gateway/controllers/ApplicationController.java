package com.neoflex.gateway.controllers;

import com.neoflex.gateway.dto.LoanApplicationRequestDTO;
import com.neoflex.gateway.dto.LoanOfferDTO;
import com.neoflex.gateway.feignclient.ApplicationClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationClient applicationClient;

    @Operation(description = "Создание заявки на кредит") //Первый
    @PostMapping("/application")
    public ResponseEntity<List<LoanOfferDTO>> createLoanApplication(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {
        log.info("createLoanApplication() - ResponseEntity<List<LoanOfferDTO>>: Получение списка предложений");
        return ResponseEntity.ok(applicationClient.application(loanApplicationRequestDTO));
    }

    @Operation(description = "Выбор предложения") //Второй
    @PutMapping("/application/offer")
    public ResponseEntity<?> applyoffer(@RequestBody LoanOfferDTO loanOfferDTO) {
        log.info("applyoffer() - ResponseEntity<?>: Выбор предложения кредита");
        return ResponseEntity.ok(applicationClient.offer(loanOfferDTO));
    }
}
