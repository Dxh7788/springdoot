package org.dano.boot.main;

import org.dano.boot.service.CircleService;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.util.DefaultPropertiesPersister;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author dongxiaohong
 * @date 2018/12/5 09:27
 */
public class DefaultListableBeanFactoryTest {

    @Test
    public void boot() throws Exception{
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("application-localTest.xml");
        AnnotationConfigUtils.registerAnnotationConfigProcessors(factory);
        DefaultPropertiesPersister persister = new DefaultPropertiesPersister();
        Properties properties = new Properties();
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        persister.load(properties, stream);
        PropertyOverrideConfigurer configurer = new PropertyOverrideConfigurer();
        configurer.setPropertiesPersister(persister);
        configurer.postProcessBeanFactory(factory);
        //把前置BeanPostProcessors处理掉
        String[] postProcessorNames = factory.getBeanNamesForType(BeanPostProcessor.class, true, false);
        for (String name:postProcessorNames){
            BeanPostProcessor postProcessor = factory.getBean(name, BeanPostProcessor.class);
            factory.addBeanPostProcessor(postProcessor);
        }
        CircleService circleService = factory.getBean("circleService", CircleService.class);
        circleService.vo();
    }
}
