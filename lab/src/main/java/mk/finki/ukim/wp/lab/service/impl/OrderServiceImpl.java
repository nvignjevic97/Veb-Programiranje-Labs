package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.repository.BalloonRepository;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final BalloonRepository balloonRepository;

    public OrderServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return null;
    }
}
