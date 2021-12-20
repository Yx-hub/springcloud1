package cn.tedu.sp03.service;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;
import cn.tedu.web.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${sp.user-service.users}")
    private String userJson;




    @Override
    public User getUser(Integer id) {

        log.info("获取用户,userId="+id);

        List<User> list = JsonUtil.from(userJson,new TypeReference<List<User>>(){});

        for(User user : list){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return new User(id,"用户名"+id,"密码"+id);
    }

    @Override
    public void addScore(Integer userId, Integer score) {
        log.info("增加用户积分，userId="+userId+",score="+score);
    }







}
