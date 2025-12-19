package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.order.OrderService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.StatusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

    private final OrderService orderService;
    private final AcaiService acaiService;

    public EmployeerController(OrderService orderService, AcaiService acaiService){
        this.orderService = orderService;
        this.acaiService = acaiService;
    }

    @GetMapping
    public String hello(){
        return "Hello to the Employeer Page";
    }


    @GetMapping("/order")
    public ResponseEntity getAllOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/order/{id}")
    public ResponseEntity updateMyOrderStatus(@PathVariable UUID id, @RequestBody StatusDTO data){
        return orderService.updateOrderStatus(id,data);
    }

    @GetMapping("/acai")
    public ResponseEntity getAllAcai(){
        return acaiService.getALl();
    }
}
