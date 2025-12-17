package com.sorverteria.Nicolas_End.SorverteriaApi.domains.order;

import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestOrderWithOutIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    // costumer
    @PostMapping
    public ResponseEntity registerMyNewOrder(@RequestBody RequestOrderWithOutIdDTO data){
        return this.orderService.registerNewOrder(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMySpecificOrder(@PathVariable UUID id){return orderService.getSpecificOrder(id);}

    @GetMapping// retornar todas os pedidos do  usuario pela credencial
    public ResponseEntity getMyOrders(){
        return orderService.getAllMyOrders();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMyOrder(@PathVariable UUID id){
        return orderService.deleteMyOrder(id);
    }





}
