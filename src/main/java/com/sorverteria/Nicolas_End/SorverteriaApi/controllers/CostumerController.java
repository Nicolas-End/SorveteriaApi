package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.acai.AcaiService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.order.OrderService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.acai.AcaiDataDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestNewStatusDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestOrderWithOutIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    private final PopsicleService popsicleService;
    private final OrderService orderService;

    private final AcaiService acaiService;

    public  CostumerController(PopsicleService popsicleService, OrderService orderService, AcaiService acaiService){
        this.popsicleService = popsicleService;
        this.orderService = orderService;

        this.acaiService = acaiService;
    }

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }


    @GetMapping("/get-popsicle-by-id/{id}")
    public ResponseEntity getPopsicleById(@PathVariable UUID id){
        return this.popsicleService.getPopsicleById(id);
    }

    @GetMapping("/get-popsicles")
    public ResponseEntity getAllPopsicle(){
        return  this.popsicleService.getAllPopsicle();
    }



    @PostMapping("/register-new-order")
    public ResponseEntity registerNewOrder(@RequestBody RequestOrderWithOutIdDTO data){
        return this.orderService.registerNewOrder(data);
    }

    @GetMapping("/get-my-orders")// retornar todas os pedidos do usuario pela credencial
    public ResponseEntity getMyOrders(){
        return orderService.getAllMyOrders();
    }

    @DeleteMapping("/delete-order-by-id/{id}")
    public ResponseEntity deleteMyOrder(@PathVariable UUID id){
        return orderService.deleteMyOrder(id);
    }

    @PostMapping("/update-order-status/{id}")
    public ResponseEntity updateOrderStatus(@PathVariable UUID id, @RequestBody RequestNewStatusDTO data){
        return orderService.updateOrderStatus(id,data);
    }


    @RequestMapping("/açai")
    public class AcaiSession{
        @PostMapping
        public ResponseEntity requestNewAcai(@RequestBody AcaiDataDTO data){
            return acaiService.addNewAcai(data);
        }
    }
}
