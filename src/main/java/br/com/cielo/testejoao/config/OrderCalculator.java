package br.com.cielo.testejoao.config;
import java.math.BigDecimal;

public class OrderCalculator {
    public BigDecimal total(BigDecimal price, int qty) {
        if (qty <= 0) throw new IllegalArgumentException("qty must be >= 1");
        return price.multiply(BigDecimal.valueOf(qty));
    }
}