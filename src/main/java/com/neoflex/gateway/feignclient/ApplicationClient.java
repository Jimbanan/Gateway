package com.neoflex.gateway.feignclient;

import com.neoflex.gateway.dto.LoanApplicationRequestDTO;
import com.neoflex.gateway.dto.LoanOfferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "applicationMC", url = "${application.hostname}")
public interface ApplicationClient {

    @PostMapping("/application")
    List<LoanOfferDTO> application(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PutMapping("/application/offer")
    List<LoanOfferDTO> offer(@RequestBody LoanOfferDTO loanOfferDTO);

}
