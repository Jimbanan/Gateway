package com.neoflex.gateway.controllers;

import com.neoflex.gateway.dto.LoanApplicationRequestDTO;
import com.neoflex.gateway.dto.LoanOfferDTO;
import com.neoflex.gateway.feignclient.ApplicationClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class AdminController {


    @Operation(description = "Создание заявки на кредит") //Первый
    @PostMapping("/AdminController")
    public ResponseEntity<?> createAdmin() {
        return null;
    }

}
