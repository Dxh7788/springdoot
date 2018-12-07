package org.dano.boot.resources;

import java.io.IOException;
import java.util.Properties;

/**
 * @author dongxiaohong
 * @date 2018/12/7 09:47
 */
public class JellyPropertiesPlacHolderConfigurer extends JellyPropertiesLoaderSupport{


    public JellyPropertiesPlacHolderConfigurer(String location) {
        super(location);
    }

    public JellyPropertiesPlacHolderConfigurer() {
        super();
    }

    @Override
    public Properties mergeProperties() throws IOException {
        return super.mergeProperties();
    }
}
