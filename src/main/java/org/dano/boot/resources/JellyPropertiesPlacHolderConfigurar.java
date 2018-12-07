package org.dano.boot.resources;

import java.io.IOException;
import java.util.Properties;

/**
 * @author dongxiaohong
 * @date 2018/12/7 09:47
 */
public class JellyPropertiesPlacHolderConfigurar extends JellyPropertiesLoaderSupport{


    public JellyPropertiesPlacHolderConfigurar(String location) {
        super(location);
    }

    public JellyPropertiesPlacHolderConfigurar() {
        super();
    }

    @Override
    public Properties mergeProperties() throws IOException {
        return super.mergeProperties();
    }
}
