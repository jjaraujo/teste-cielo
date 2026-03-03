package br.com.cielo.testejoao.dtos;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        Long id,
        List<OrderItemResponse> items,
        BigDecimal total
) {}