package com.sorverteria.Nicolas_End.SorverteriaApi.domains.order;

import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleRepository;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.popsicle.PopsicleService;
import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.OrdersDatasDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestNewStatusDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.orders.RequestOrderWithOutIdDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.OrderStatus;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthenticatedUser;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

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
        if (popsicle.getQuantityInStock() == 0 ) return ResponseEntity.status(HttpStatus.CONFLICT).body("produto sem estoque");
        if (data.quantityOrdered() > popsicle.getQuantityInStock()) return ResponseEntity.status(HttpStatus.CONFLICT).body("quantidade insuficiente");


        popsicle.setQuantityInStock(popsicle.getQuantityInStock()-data.quantityOrdered());
        this.popsicleRepository.save(popsicle);

        if (popsicle == null) return ResponseEntity.notFound().build();

        OrderEntity order = new OrderEntity();
        order.setPopsicle(popsicle);
        order.setStatus(OrderStatus.PENDENTE);
        order.setUser(authUser.get());
        order.setQuantityOrdered(data.quantityOrdered());

        OrderEntity infos = orderRepository.save(order);
        return ResponseEntity.ok("Pedido Cadastrado com sucesso");
    }

    public ResponseEntity getAllMyOrders(){
        List<OrderEntity> orders = orderRepository.findByUser(authUser.get());
        if (orders.isEmpty()) return ResponseEntity.notFound().build();

        List<OrdersDatasDTO> ordersDatas = orders.stream()// percorre kd objto da lista
                .map(order -> new OrdersDatasDTO( // map permite a modificação da lista
                        order.getId(),
                        order.getStatus(),
                        order.getPopsicle().getFlavor(),
                        order.getPopsicle().getPriceByUnit(),
                        order.getQuantityOrdered()
                )).toList(); // esse codigo "retransforma" a lista ordes para o formato que eu desejo
        return ResponseEntity.ok(ordersDatas);
    }

    public ResponseEntity UpdateOrdersInfos(){// função que ira modificar todas as informações do pedido
        return ResponseEntity.ok("Informações modificadas");
    }


    @Transactional
    public ResponseEntity deleteMyOrder(UUID id){
        OrderEntity order = orderRepository.findByIdAndUser(id,authUser.get());
        if (order == null) return ResponseEntity.notFound().build();

        PopsicleEntity popsicle = popsicleService.verifyPopsicleId(order.getPopsicle().getId());

        popsicle.setQuantityInStock(popsicle.getQuantityInStock() + order.getQuantityOrdered());

        popsicleRepository.save(popsicle);
        orderRepository.delete(order);// deleta pesquisando pela proria entidade em questão

        return ResponseEntity.ok("Pedido deletado com sucesso");
    }

    public ResponseEntity updateOrderStatus(UUID id, RequestNewStatusDTO data){
        OrderEntity order = orderRepository.findByIdAndUser(id,authUser.get());
            if (order == null) return ResponseEntity.notFound().build();

        order.setStatus(data.newStatus());

        orderRepository.save(order);

        return ResponseEntity.ok("Status do pedido modificado com sucesso");
    }
}
