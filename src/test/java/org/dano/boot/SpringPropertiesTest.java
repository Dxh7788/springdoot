package org.dano.boot;

import org.junit.Test;
import org.springframework.core.SpringProperties;

/**
 * @author dongxiaohong on
 * @date 2018/11/23 14:47
 */
public class SpringPropertiesTest {

    @Test
    public void springPropertiesTest(){
        boolean b = SpringProperties.getFlag("test");
        if (!b){
            System.out.println("SUCCESS");
        }
    }
}
