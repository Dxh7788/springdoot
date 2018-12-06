package org.dano.boot.model;

import org.dano.boot.annotation.Dest;
import org.dano.boot.annotation.Dests;
//import org.springframework.core.annotation.AliasFor;

/**
 * @author dongxiaohong
 * @date 2018/12/5 14:19
 */
public class Processor {
    @Dests(value = {
            @Dest(value = "123"),
            @Dest(value = "456"),
            @Dest(value = "789")
    })
    private String name;
    /*@AliasFor(attribute = "kl2",value = "kl2")
    public void kl(){
        System.out.println("AliasFor Testing ....");
    }*/
}
