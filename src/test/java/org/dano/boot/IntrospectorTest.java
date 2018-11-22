package org.dano.boot;

import org.dano.boot.model.User;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * @author dongxiaohong on
 * @date 2018/11/22 19:33
 */
public class IntrospectorTest {

    @Test
    public void test01(){
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
            System.out.println(beanInfo);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
