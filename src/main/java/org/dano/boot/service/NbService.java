package org.dano.boot.service;

import org.dano.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohong on 2018/11/12 19:11
 */
@Service
public class NbService {

    @Autowired
    private CircleService circleService;

    public void vo(){
        System.out.println("....Vo Virgin!!!");
        circleService.voCopy();
    }
    public User getUser(String name,GeFactory geFactory){
        return geFactory.getUser();
    }
}
