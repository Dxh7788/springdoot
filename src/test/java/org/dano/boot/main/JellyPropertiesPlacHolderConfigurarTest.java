package org.dano.boot.main;

import org.dano.boot.resources.JellyPropertiesPlacHolderConfigurar;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * @author dongxiaohong
 * @date 2018/12/7 09:47
 */
public class JellyPropertiesPlacHolderConfigurarTest {

    @Test
    public void mergePropertiesTest() throws IOException {
        JellyPropertiesPlacHolderConfigurar configurar = new JellyPropertiesPlacHolderConfigurar("application.properties");
        Properties properties = configurar.mergeProperties();
        properties.list(System.out);
    }
}
