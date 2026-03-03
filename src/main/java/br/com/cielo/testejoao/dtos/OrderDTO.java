package br.com.cielo.testejoao.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(
        @NotBlank @Max(9999999) BigDecimal id,
        @NotBlank List<ItemDTO> items
) {
}
