package cn.tedu.service;

import cn.tedu.entity.User;

public interface UserService {

    User getUser(Integer id);



    //增加积分
    void addScore(Integer userId, Integer score);

}
