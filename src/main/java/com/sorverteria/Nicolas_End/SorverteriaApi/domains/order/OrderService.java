package com.sorverteria.Nicolas_End.SorverteriaApi.domains.order;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleRepository;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.OrdersDatasDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestOrderWithOutIdDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthenticatedUser;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PopsicleService popsicleService;
    private final PopsicleRepository popsicleRepository;
    private final AuthenticatedUser authUser;

    public OrderService(OrderRepository orderRepository, PopsicleService popsicleService, PopsicleRepository popsicleRepository, AuthenticatedUser authUser){
        this.orderRepository = orderRepository;
        this.popsicleService = popsicleService;
        this.popsicleRepository = popsicleRepository;
        this.authUser = authUser;
    }

    public ResponseEntity registerNewOrder(RequestOrderWithOutIdDTO data){

        PopsicleEntity popsicle = popsicleService.verifyPopsicleId(data.popsicleId());

        if (data.quantityOrdered() > popsicle.getQuantityInStock()) return ResponseEntity.status(HttpStatus.CONFLICT).body("Não pode pedir mais do que há no estoque");


        popsicle.setQuantityInStock(popsicle.getQuantityInStock()-data.quantityOrdered());
        this.popsicleRepository.save(popsicle);

        if (popsicle == null) return ResponseEntity.notFound().build();

        OrderEntity order = new OrderEntity();
        order.setPopsicle(popsicle);
        order.setUser(authUser.get());
        order.setQuantityOrdered(data.quantityOrdered());

        OrderEntity infos = orderRepository.save(order);
        return ResponseEntity.ok("Pedido Cadastrado com sucesso");
    }

    public ResponseEntity getMyOrders(){
        List<OrderEntity> orders = orderRepository.findByUser(authUser.get());
        if (orders.isEmpty()) return ResponseEntity.notFound().build();

        List<OrdersDatasDTO> ordersDatas = orders.stream()// percorre kd objto da lista
                .map(order -> new OrdersDatasDTO( // map permite a modificação da lista
                        order.getId(),
                        order.getPopsicle().getFlavor(),
                        order.getPopsicle().getPriceByUnit(),
                        order.getQuantityOrdered()
                )).toList(); // esse codigo "retransforma" a lista ordes para o formato que eu desejo





        return ResponseEntity.ok(ordersDatas);
    }
}
