package org.dano.boot;

import net.sf.json.JSONObject;
import org.dano.boot.model.CopyUser;
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
    /**
     * JSONObject不支持ExtendedBeanInfo的另一种write方法，即:
     * public User setName(String name){
     *     this.name = name;
     *     return this;
     * }
     * ExtendedBeanInfo还有另外一种write形式
     * public User setName(int count,String name){
     *     this.count = count;
     *     this.name = name;
     *     return this;
     * }
     * */
    @Test
    public void extendedBeanInfoTest2(){
        ExtendedBeanInfoFactory factory = new ExtendedBeanInfoFactory();
        try {
            String json = "{\"name\":\"dxh\",\"password\":\"123456\"}";
            JSONObject jsonObject = JSONObject.fromObject(json);
            User o = (User) (JSONObject.toBean(jsonObject, User.class));
            System.out.println(o.getName());
            BeanInfo beanInfo = factory.getBeanInfo(CopyUser.class);
            System.out.println("");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}