package p.hin.ec.controller;

import p.hin.ec.common.Constant;
import p.hin.ec.dao.Item;
import p.hin.ec.dao.Order;
import p.hin.ec.service.ItemService;
import p.hin.ec.service.OrderService;
import p.hin.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    OrderService service;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public List<Order> getCartOrder(int userId) {
        List<Order> orders = service.getCartOrders(userId);

        for (Order order : orders) {
            Item item = itemService.getItemByItemId(order.getItemId());
            order.setPrice(String.valueOf(Double.valueOf(item.getPrice()) * order.getCount()));
            order.setTitle(item.getTitle());
            order.setItemPic(item.getItemPic0());
        }

        return orders;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public void addToCart(int userId, int itemId, int count) {
        Order newOrder = new Order();
        Item item = itemService.getItemByItemId(itemId);

        newOrder.setBuyerId(userId);
        newOrder.setCount(count);
        newOrder.setDate(new Date());
        newOrder.setItemId(itemId);
        newOrder.setStatus(Constant.ORDER_CART);
        newOrder.setUploaderId(item.getUploader());

        service.addItemToCart(newOrder);
    }

    @RequestMapping(value = "/cart/{orderId}", method = RequestMethod.PUT)
    public void removeFromCart(@PathVariable("orderId") int orderId) {
        service.removeItemFromCart(orderId);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.PUT)
    public void updateOrderFromCart(Order order) {
        service.updateOrder(order);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getOrder(int userId) {
        int userType = userService.getUserType(userId);
        List<Order> orders = new ArrayList<>();
        switch (userType) {
            case Constant.USER_TYPE_BUYER:
                orders = service.getOrdersByBuyerId(userId);
                break;
            case Constant.USER_TYPE_UPLOADER:
                orders = service.getOrdersByUploaderId(userId);
                break;
        }
        return orders;
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public void updateOrderStatus(Order order, int orderStatus) {
        order.setStatus(orderStatus);
        service.updateOrder(order);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
    public void refundOrder(@PathVariable("orderId") int orderId) {
        Order order = service.getOrder(orderId);
        order.setStatus(Constant.ORDER_REFUNDED);
        service.updateOrder(order);
    }
}
