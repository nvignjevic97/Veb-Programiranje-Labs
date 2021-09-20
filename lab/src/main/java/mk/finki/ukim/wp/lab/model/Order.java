package mk.finki.ukim.wp.lab.model;

import lombok.Data;

@Data
public class Order {
    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;
    Long orderId;

    public Order(String balloonColor) {
        this.balloonColor = balloonColor;
        this.balloonSize = "";
        this.clientName = "";
        this.clientAddress = "";
        this.orderId = 0L;
    }

    public Order(String balloonColor, String balloonSize) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = "";
        this.clientAddress = "";
        this.orderId = 0L;
    }

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }


}
