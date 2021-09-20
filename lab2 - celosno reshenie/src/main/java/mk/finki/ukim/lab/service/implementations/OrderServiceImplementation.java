package mk.finki.ukim.lab.service.implementations;

import mk.finki.ukim.lab.model.Order;
import mk.finki.ukim.lab.repository.OrderRepository;
import mk.finki.ukim.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {

        return  orderRepository.addOrder(balloonColor, clientName, address);
    }

    @Override
    public List<Order> searchByClient(String name, String address) {
        return orderRepository.listByNameAndAddress(name, address);
    }
}
