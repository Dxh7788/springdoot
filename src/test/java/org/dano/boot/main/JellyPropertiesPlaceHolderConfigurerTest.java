package org.dano.boot.main;

import org.dano.boot.resources.JellyPropertiesPlacHolderConfigurer;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * @author dongxiaohong
 * @date 2018/12/7 09:47
 */
public class JellyPropertiesPlaceHolderConfigurerTest {

    @Test
    public void mergePropertiesTest() throws IOException {
        JellyPropertiesPlacHolderConfigurer configurer = new JellyPropertiesPlacHolderConfigurer("application.properties");
        Properties properties = configurer.mergeProperties();
        properties.list(System.out);
    }
}
