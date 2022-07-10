package com.neoflex.gateway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dealMC", url = "${deal.hostname}")
public interface DealClient {

    @PutMapping("deal/calculate/{applicationId}")
    ResponseEntity<?> choosingApplication(@RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                                          @PathVariable Long applicationId);

}
