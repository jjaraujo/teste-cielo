package br.com.cielo.testejoao.dtos;

import java.math.BigDecimal;

public record OrderItemResponse(Long id, String sku,
                                int quantity,
                                BigDecimal price,
                                BigDecimal lineTotal) {
}
