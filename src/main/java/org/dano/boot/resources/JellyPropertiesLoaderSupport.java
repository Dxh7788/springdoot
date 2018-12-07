package org.dano.boot.resources;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * properties文件解析器
 * @author dongxiaohong
 * @date 2018/12/7 09:25
 */
public abstract class JellyPropertiesLoaderSupport {

    /**文件所处位置*/
    private String location;

    /**属性解析后的存储*/
    private Properties properties;

    public JellyPropertiesLoaderSupport(String location) {
        this.location = location;
    }

    public JellyPropertiesLoaderSupport() {
    }

    public String getLocation() {
        return location;
    }

    public Properties getProperties() {
        return properties;
    }

    protected Properties mergeProperties() throws IOException {
        Properties result = new Properties();
        loadProperties(result);
        return result;
    }

    /**加载并解析location处的属性配置文件*/
    protected void loadProperties(Properties props) throws IOException {
        ClassLoader c = Thread.currentThread().getContextClassLoader();
        if (c == null){
            c = JellyPropertiesLoaderSupport.class.getClassLoader();
            if (c == null){
                c= this.getClass().getClassLoader();
            }
        }
        URL resource = c.getResource(location);
        props.load(resource.openStream());
    }
}
