package p.hin.ec.mapper;

import p.hin.ec.dao.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into t_order(itemId,buyerId,count,status,date) values(#{itemId},#{buyerId},#{count},#{status},#{date})")
    void createNewOrder(Order order);

    @Update("update t_order set status=#{status}, count=#{count}, orderSignature=#{orderSignature}, date=#{date} where orderId=#{orderId}")
    void updateOrder(Order order);

    @Select("select * from t_order where orderId = #{orderId}")
    Order getOrderByOrderId(int orderId);

    @Select("select * from t_order where buyerId=#{buyerId} and status=0")
    List<Order> getCartOrdersByBuyerId(int buyerId);

    @Select("select * from t_order where buyerId=#{buyerId} and status!=0")
    List<Order> getOrdersByBuyerId(int buyerId);

    @Select("select * from t_order where uploaderId = #{uploaderId}")
    List<Order> getOrdersByUploaderId(int uploaderId);

    @Delete("delete from t_order where orderId=#{0}")
    void deleteOrder(int orderId);
}
