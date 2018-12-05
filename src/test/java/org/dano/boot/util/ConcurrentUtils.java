package org.dano.boot.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongxiaohong
 * @date 2018/12/4 14:00
 */
public class ConcurrentUtils {

    @Test
    public void concurrentUtilsTest(){

    }
    @Test
    public void setAddTest(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("dxh");
        if (!stringSet.add("dxh")){
            System.out.println("值已经存在,无法继续添加!!!");
        }
    }
}
