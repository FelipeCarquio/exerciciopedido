package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double tot = 0;
        for (OrderItem i : items) {
            tot += i.subTotal();
        }
        return tot;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Order Summary: \n");
       sb.append("Order moment: " + dateFormat.format(moment) + "\n");
       sb.append("Order status: " + status + "\n");
       sb.append(client.toString() + "\n");
       sb.append("Order items: \n");
       for (OrderItem x : items) {
            sb.append(x.toString() + "\n");
       }
       sb.append("Total price: R$ ");
       sb.append(String.format("%.2f", total()));
       return sb.toString();
    }

}
