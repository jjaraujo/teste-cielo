package br.com.cielo.testejoao;

import br.com.cielo.testejoao.config.OrderCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    @Test
    void shouldCalculateTotal() {
        var calc = new OrderCalculator();
        var total = calc.total(new BigDecimal("10.50"), 2);
        assertEquals(new BigDecimal("21.00"), total);
    }

    @Test
    void shouldRejectInvalidQty() {
        var calc = new OrderCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.total(new BigDecimal("10.00"), 0));
    }
}