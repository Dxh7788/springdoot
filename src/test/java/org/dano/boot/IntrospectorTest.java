package org.dano.boot;

import org.dano.boot.model.User;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.ExtendedBeanInfoFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author dongxiaohong on
 * @date 2018/11/22 19:33
 */
public class IntrospectorTest {

    @Test
    public void beanInfo01() {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
            System.out.println(beanInfo);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cachedIntrospectionResultsTest() {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(User.class);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getName() + ",class:" + propertyDescriptor.getPropertyType());
        }
    }
    @Test
    public void extendedBeanInfoTest(){
        ExtendedBeanInfoFactory factory = new ExtendedBeanInfoFactory();
        try {
            BeanInfo beanInfo = factory.getBeanInfo(User.class);
            System.out.println("");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}