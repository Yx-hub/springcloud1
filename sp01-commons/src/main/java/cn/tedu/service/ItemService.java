package cn.tedu.service;

import cn.tedu.entity.Item;

import java.util.List;

public interface ItemService {

    //获取订单列表
    List<Item> getItems(String orderId);

    //减少商品库存
    void decreaseNumbers(List<Item> list);

}
