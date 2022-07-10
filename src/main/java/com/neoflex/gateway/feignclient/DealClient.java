package com.neoflex.gateway.feignclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neoflex.gateway.dto.ApplicationDTO;
import com.neoflex.gateway.dto.FinishRegistrationRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "dealMC", url = "${deal.hostname}")
public interface DealClient {

    @PutMapping("deal/calculate/{applicationId}")
    ResponseEntity<?> calculate(@RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                                @PathVariable Long applicationId);

    @PostMapping("deal/document/{applicationId}/send")
    ResponseEntity<?> sendDocs(@PathVariable Long applicationId);

    @PostMapping("deal/document/{applicationId}/sign")
    ResponseEntity<?> singDocs(@PathVariable Long applicationId);

    @PostMapping("deal/document/{applicationId}/code")
    ResponseEntity<?> receiveSesCode(@PathVariable Long applicationId,
                                     @RequestBody Integer sesCode);

    @GetMapping("/deal/admin/application/{applicationId}")
    ApplicationDTO getOffersByID(@PathVariable Long applicationId);

    @GetMapping("/deal/admin/application")
    List<ApplicationDTO> getAllOffers();

}
