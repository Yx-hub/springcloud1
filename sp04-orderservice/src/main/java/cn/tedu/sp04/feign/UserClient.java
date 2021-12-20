package cn.tedu.sp04.feign;

import cn.tedu.entity.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@FeignClient(name = "user-service" , contextId = "userClient")
public interface UserClient {

    @GetMapping("/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId);



    @GetMapping("/{userId}/score")
    public JsonResult<?> addScore(@PathVariable  Integer userId, @RequestParam("score") Integer score);
}
