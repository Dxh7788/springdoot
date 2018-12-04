package org.dano.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohong on
 * @date 2018/11/30 14:49
 */
@Service
public class CircleService {

    @Autowired
    private NbService nbService;

    @Value("${road.toy.name}")
    private String name;

    public void vo(){
        nbService.vo();
    }

    public void voCopy() {
        System.out.println("....Vo Copy!!!");
        System.out.println(name);
    }
}
