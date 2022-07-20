package com.neoflex.gateway.controllers;

import com.neoflex.gateway.dto.FinishRegistrationRequestDTO;
import com.neoflex.gateway.feignclient.DealClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class DealController {

    private final DealClient dealClient;

    @Operation(description = "Расчет по выбранной заявке") //Третий
    @PostMapping("/calculate/{applicationId}")
    public ResponseEntity<?> finishRegistration(@RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                                                @PathVariable Long applicationId) {
        log.info("finishRegistration() - ResponseEntity<?>: Создание заявки на кредит");
        dealClient.calculate(finishRegistrationRequestDTO, applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(description = "Запрос на отправку документов")//Четвертый
    @PostMapping("/document/{applicationId}/send")
    public ResponseEntity<?> sendDocs(@PathVariable Long applicationId) {
        log.info("sendDocs() - ResponseEntity<?>: Запрос на отправку документов");
        dealClient.sendDocs(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(description = "Запрос на подписание документов") //Пятый
    @PostMapping("/document/{applicationId}/sign")
    public ResponseEntity<?> singDocs(@PathVariable Long applicationId) {
        log.info("singDocs() - ResponseEntity<?>: Запрос на подписание документов");
        dealClient.singDocs(applicationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(description = "Подписание документов") //Шестой
    @PostMapping("/document/{applicationId}/code")
    public ResponseEntity<?> receiveSesCode(@PathVariable Long applicationId,
                                            @RequestBody Integer sesCode) {
        log.info("receiveSesCode() - ResponseEntity<?>: Подписание документов");
        dealClient.receiveSesCode(applicationId, sesCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
