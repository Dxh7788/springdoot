package org.dano.boot.service;

import org.dano.boot.model.User;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohong on 2018/11/12 19:11
 */
@Service
public class NbService {

    public void vo(){
        System.out.println("....xxx");
        User user = getUser("ddd", ()->{
            return new User();
        });
    }
    public User getUser(String name,GeFactory geFactory){
        return geFactory.getUser();
    }
}
