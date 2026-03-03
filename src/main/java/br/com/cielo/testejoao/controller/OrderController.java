package br.com.cielo.testejoao.controller;

import br.com.cielo.testejoao.domain.Order;
import br.com.cielo.testejoao.dtos.CreateOrderRequest;
import br.com.cielo.testejoao.dtos.OrderItemResponse;
import br.com.cielo.testejoao.dtos.OrderResponse;
import br.com.cielo.testejoao.exception.BusinessException;
import br.com.cielo.testejoao.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest req) throws BusinessException {
        return toResponse(service.create(req));
    }

    @GetMapping("/{id}") //apesar de redimdamte, precisa colocar o nome "id" se nao o swagger nao mapeia
    public OrderResponse get(@PathVariable("id") Long id) throws BusinessException {
        return toResponse(service.getById(id));
    }

    private static OrderResponse toResponse(Order order) {
        var items = order.getItems().stream()
                .map(i -> new OrderItemResponse(i.getId(), i.getSku(), i.getQuantity(), i.getPrice(), i.getLineTotal()))
                .toList();
        return new OrderResponse(order.getId(), items, order.getTotal());
    }
}