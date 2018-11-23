package org.dano.boot;

import org.dano.boot.model.User;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author dongxiaohong on
 * @date 2018/11/23 15:53
 */
public class BeanWrapperImplTest {

    @Test
    public void beanWrapperTest01() throws IOException {
        ClassLoader loader = BeanWrapperImplTest.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("user.properties");
        Properties properties = new Properties();
        properties.load(stream);
        Set<String> sets = properties.stringPropertyNames();
        Map<String,String> map = new HashMap<>();
        for (String set:sets){
            map.put(set,properties.getProperty(set));
        }
        User user = new User();
        BeanWrapper wrapper = new BeanWrapperImpl(user);
        //一切的玄机都在 wrapper.setPropertyValues和wrapper.getPropertyValue中
        wrapper.setPropertyValues(map);
        if (wrapper.getPropertyValue("age") instanceof Integer){
            System.out.println("SUCCESS!!!");
        }
        System.out.println(wrapper.getPropertyValue("name"));
    }
}
