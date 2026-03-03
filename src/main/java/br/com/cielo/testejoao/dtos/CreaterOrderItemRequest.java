package br.com.cielo.testejoao.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreaterOrderItemRequest(
         Long id,
        @NotBlank(message = "sku é obrigatorio") String sku,
        @NotNull(message = "quantity é obrigatorio") @Min(message = "quantity deve ser > 1", value = 1) Integer quantity,
        @NotNull(message = "price é obrigatorio") @DecimalMin(value = "0.00", inclusive = true, message = "price deve ser > 0") BigDecimal price
) {}