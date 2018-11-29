package org.dano.boot;

import org.dano.boot.model.CloneUser;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dongxiaohong on
 * @date 2018/11/26 09:27
 */
public class CloneTest {
    @Test
    public void objectCloneTest(){
        try {
            CloneUser user = new CloneUser().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void objectTest(){
        Object NULL_OBJECT = new Object();
        Map<String,Object> map = new ConcurrentHashMap<>(0);
        map.put("flag",NULL_OBJECT);

        if (map.get("flag") == NULL_OBJECT){
            System.out.println("这是一个真条件");
        }
    }
}
