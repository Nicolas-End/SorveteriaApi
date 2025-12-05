package com.sorverteria.Nicolas_End.SorverteriaApi.service;

import com.sorverteria.Nicolas_End.SorverteriaApi.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
}
