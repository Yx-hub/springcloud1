package cn.tedu.sp04.service;

import cn.tedu.entity.Item;
import cn.tedu.entity.Order;
import cn.tedu.entity.User;
import cn.tedu.service.OrderService;
import cn.tedu.sp04.feign.ItemClient;
import cn.tedu.sp04.feign.UserClient;
import cn.tedu.web.util.JsonResult;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemClient itemClient;
    @Autowired
    private UserClient userClient;


    @Override
    public Order gerOrder(String id) {
        log.info("获取订单，orderId="+id);
        JsonResult<List<Item>>items = itemClient.getItems(id);
        JsonResult<User> user = userClient.getUser(8);
        //TODD: 调用user-service获取用户信息
        //TODD： 调用item-service获取商品信息
        Order order = new Order();
        order.setId(id);
        order.setItems(items.getData());
        order.setUser(user.getData());
        return order;
    }

    @Override
    public void addOrder(Order order) {
        log.info("添加订单："+order);
        //TODD：调用item-service减少商品库存
        itemClient.decreaseNumbers(order.getItems());
        //TODD：调用user-service增加用户积分
        userClient.addScore(order.getUser().getId(), 1000);
    }

}
