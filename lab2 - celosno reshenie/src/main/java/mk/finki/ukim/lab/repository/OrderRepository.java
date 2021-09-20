package mk.finki.ukim.lab.repository;

import mk.finki.ukim.lab.database.Dataholder;
import mk.finki.ukim.lab.model.Order;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    public List<Order> listByNameAndAddress(String clientName, String clientAddress) {
        return Dataholder.ordersList.stream()
                .filter(o -> o.getClientName().equals(clientName) && o.getClientAddress().equals(clientAddress))
                .collect(Collectors.toList());
    }

    public Order addOrder(String balloonColor, String clientName, String clientAddress) {
        Order order = new Order(balloonColor, balloonColor + " balloon", clientName, clientAddress);
        Dataholder.ordersList.add(order);
        return order;
    }
}
