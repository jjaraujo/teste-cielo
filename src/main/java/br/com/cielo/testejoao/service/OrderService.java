package br.com.cielo.testejoao.service;

import br.com.cielo.testejoao.domain.Order;
import br.com.cielo.testejoao.domain.OrderItem;
import br.com.cielo.testejoao.dtos.CreateOrderRequest;
import br.com.cielo.testejoao.dtos.CreaterOrderItemRequest;
import br.com.cielo.testejoao.exception.BusinessException;
import br.com.cielo.testejoao.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Order create(CreateOrderRequest req) throws BusinessException {
        if (req.id() != null && repo.existsById(req.id())) {
            throw new BusinessException("Pedido já existe: " + req.id());
        }

        Order order = new Order(req.id());

        for (CreaterOrderItemRequest i : req.items()) {
            BigDecimal lineTotal = i.price().multiply(BigDecimal.valueOf(i.quantity()));
            OrderItem item = new OrderItem(i.sku(), i.quantity(), i.price(), lineTotal);
            order.addItem(item);
        }

        BigDecimal total = order.getItems().stream()
                .map(OrderItem::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotal(total);

        return repo.save(order);
    }

    @Transactional(readOnly = true)
    public Order getById(Long id) throws BusinessException {
        return repo.findById(id)
                .orElseThrow(() -> new BusinessException("Pedido não encontrado: " + id));
    }
}