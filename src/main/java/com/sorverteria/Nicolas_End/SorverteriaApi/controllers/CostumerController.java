package com.sorverteria.Nicolas_End.SorverteriaApi.controllers;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.accompaniment.AccompanimentService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.fruits.FruitsService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.order.OrderService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserService;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestNewStatusDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestOrderWithOutIdDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.RequestNewCpfDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    private final PopsicleService popsicleService;
    private final OrderService orderService;
    private final AccompanimentService accompanimentService;
    private final FruitsService fruitsService;

    public  CostumerController(PopsicleService popsicleService, OrderService orderService, UserService userService, AccompanimentService accompanimentService, FruitsService fruitsService){
        this.popsicleService = popsicleService;
        this.orderService = orderService;
        this.accompanimentService = accompanimentService;
        this.fruitsService = fruitsService;
    }

    @GetMapping
    public String hello (){
        return "Hello to the costumer Page";
    }

    @PostMapping("/get-popsicle-by-id/{id}")
    public ResponseEntity getPopsicleById(@PathVariable UUID id){
        return this.popsicleService.getPopsicleById(id);
    }

    @PostMapping("/get-popsicles")
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


    @GetMapping("/get-all-fruits")
    public ResponseEntity getAllFruits(){
        return this.fruitsService.getAllFruits();
    }

    @GetMapping("/get-fruit/{id}")
    public ResponseEntity getInfoFruit(@PathVariable UUID id){
        return this.fruitsService.getInfoFruitWithouIdAndAcais(id);
    }

    @GetMapping("/get-accompaniment/{id}")
    public ResponseEntity getInfoAccompaniment(@PathVariable UUID id){
        return this.accompanimentService.getInfoAccompanimentToCostumer(id);
    }
    @GetMapping("/get-all-accompaniment")
    public ResponseEntity getAllAccompaniment(){
        return this.accompanimentService.getAllAccompaniment();
    }

}
