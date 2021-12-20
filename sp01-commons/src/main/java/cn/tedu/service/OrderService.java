package cn.tedu.service;

import cn.tedu.entity.Order;

public interface OrderService {

    Order gerOrder(String id);


    //增加订单
    void addOrder(Order order);


}
