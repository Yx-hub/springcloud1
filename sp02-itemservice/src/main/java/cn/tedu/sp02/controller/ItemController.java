package cn.tedu.sp02.controller;

import cn.tedu.entity.Item;
import cn.tedu.service.ItemService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId) throws InterruptedException {
        List<Item> items = itemService.getItems(orderId);




        if(Math.random() <0.9){
            int t = new Random().nextInt(5000);
            log.info("暂停:"+t);
            Thread.sleep(t);
        }






        return JsonResult.build().code(200).data(items);

    }



    @PostMapping("/decreaseNumber")
    public JsonResult<?> decreaseNumbers(@RequestBody List<Item> items){
        itemService.decreaseNumbers(items);
        return JsonResult.build().code(200).msg("减少库存成功");
    }


    @GetMapping("/favicon.ico")
    public void ico(){}





}
