package com.neoflex.gateway.controllers;

import com.neoflex.gateway.dto.ApplicationDTO;
import com.neoflex.gateway.feignclient.DealClient;
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
public class AdminController {

    private final DealClient dealClient;

    @Operation(description = "Получение заявки по id")
    @GetMapping("/deal/admin/application/{applicationId}")
    public ResponseEntity<ApplicationDTO> getOffersByID(@PathVariable(value = "Id заявки") Long applicationId) {
        log.info("getOffersByID() - ResponseEntity<ApplicationDTO>: Получение заявки по id");
        return ResponseEntity.ok(dealClient.getOffersByID(applicationId));
    }

    @Operation(description = "Получение всех заявок")
    @GetMapping("/deal/admin/application")
    public ResponseEntity<List<ApplicationDTO>> getAllOffers() {
        log.info("getAllOffers() - ResponseEntity<List<ApplicationDTO>>: Получение всех заявок");
        return ResponseEntity.ok(dealClient.getAllOffers());
    }

}
