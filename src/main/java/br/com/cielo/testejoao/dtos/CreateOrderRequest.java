package br.com.cielo.testejoao.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record CreateOrderRequest(
        Long id,
        @NotNull(message = "itens sao obrigatorios") @Size(min = 1) List<@Valid CreaterOrderItemRequest> items
) {}

