package org.dano.boot.main;

import org.dano.boot.model.Processor;
import org.dano.boot.service.CircleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AliasFor;
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
    /**
     * 为了测试searchWithGetSemantics是什么用途
     * 以AliasFor为例,它内部的两个方法属性,value和attribute只要有一个设置成功,另外一个如果不设置则自动设置为已经设置属性的值
     * 如果value='kl' 则attribute='kl',如果attribute='kl',则value='kl',但是只能同时设置唯一一个值.要么设置value,要么设置attribute,不能同时设置value和attribute
     * 这就是merge的作用
     * */
    @Test
    public void autoWiredAnnotationBeanPostProcessorTest(){
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setAutowiredAnnotationType(AliasFor.class);

        processor.postProcessPropertyValues(null, null, new Processor(), "processor");
    }
}
