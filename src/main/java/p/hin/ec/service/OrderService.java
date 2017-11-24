package p.hin.ec.service;

import p.hin.ec.dao.Order;
import p.hin.ec.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper mapper;

    public List<Order> getOrdersByBuyerId(int buyerId) {
        return mapper.getOrdersByBuyerId(buyerId);
    }

    public List<Order> getOrdersByUploaderId(int uploaderId) {
        return mapper.getOrdersByUploaderId(uploaderId);
    }

    public void addItemToCart(Order order) {
        mapper.createNewOrder(order);
    }

    public void removeItemFromCart(int orderId) {
        mapper.deleteOrder(orderId);
    }

    public List<Order> getCartOrders(int buyerId) {
        return mapper.getCartOrdersByBuyerId(buyerId);
    }

    public void updateOrder(Order order) {
        mapper.updateOrder(order);
    }

    public Order getOrder(int orderId) {
        return mapper.getOrderByOrderId(orderId);
    }

    public void addOrder(Order order){
        mapper.createNewOrder(order);
    }
}
