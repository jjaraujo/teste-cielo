package br.com.cielo.testejoao.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ItemDTO(
        @NotBlank @Size(min = 8, max = 12) String sku,
        @NotBlank @Max(100) String quantity,
        @NotBlank @Max(9999999) BigDecimal price
) {

}
