package cn.tedu.sp04.feign;

import cn.tedu.entity.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.bind.util.JAXBSource;
import java.util.List;

@FeignClient(name = "item-service" , contextId = "itemClient")
public interface ItemClient {

    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId);



    @PostMapping("/decreaseNumber")
    public JsonResult<?> decreaseNumbers(@RequestBody List<Item> items);


}
