package com.neoflex.gateway.dto;

import com.neoflex.gateway.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность истории статусов")
public class ApplicationStatusHistoryDTO {

    private Status status;
    private LocalDateTime time;

}
