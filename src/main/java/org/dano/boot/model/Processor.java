package org.dano.boot.model;

import org.springframework.core.annotation.AliasFor;

/**
 * @author dongxiaohong
 * @date 2018/12/5 14:19
 */
public class Processor {
    @AliasFor(attribute = "kl2",value = "kl2")
    public void kl(){
        System.out.println("AliasFor Testing ....");
    }
}
