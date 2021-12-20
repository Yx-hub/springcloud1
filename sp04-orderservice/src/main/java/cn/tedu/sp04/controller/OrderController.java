package cn.tedu.sp04.controller;

import cn.tedu.entity.Item;
import cn.tedu.entity.Order;
import cn.tedu.entity.User;
import cn.tedu.service.OrderService;
import cn.tedu.web.util.JsonResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable("orderId") String orderId){
        Order order = orderService.gerOrder(orderId);
        return JsonResult.build().code(200).data(order);
    }

    @GetMapping("/add")
    public JsonResult<?> addOrder(){
        Order order = new Order();
        order.setId("123abc");
        order.setUser(new User(7,null,null));
        order.setItems(Arrays.asList(new Item[]{
                new Item(1,"商品1",2),
                new Item(2,"商品2",1),
                new Item(3,"商品3",3),
                new Item(4,"商品4",1),
                new Item(5,"商品5",5),
        }));

        orderService.addOrder(order);

        return JsonResult.build().code(200).msg("添加订单成功");
    }


    @GetMapping("/favicon.ico")
    public void ico(){}


}
