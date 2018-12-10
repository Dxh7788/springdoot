package org.dano.boot;

import org.dano.boot.annotation.SpringBootApplication;
import org.dano.boot.context.AnnotationConfigServletWebServerApplicationContext;
import org.dano.boot.listener.GenericJelly;
import org.dano.boot.listener.JellyEvent;
import org.dano.boot.model.User;
import org.dano.boot.service.NbService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author dongxiaohong on 2018/11/12 14:10
 */
@SpringBootApplication
public class ApoloApplication {

    public void run(){
        BeanDefinitionRegistry registry = null;
        ApplicationContext context = new AnnotationConfigServletWebServerApplicationContext();

        //设置Environment,暂时不管系统env和系统properties
        ConfigurableEnvironment environment = new StandardEnvironment();

        ((AnnotationConfigServletWebServerApplicationContext) context).setEnvironment(environment);
        if (context instanceof BeanDefinitionRegistry) {
            registry =  (BeanDefinitionRegistry) context;
        }
        if (context instanceof AbstractApplicationContext) {
            registry = (BeanDefinitionRegistry) ((AbstractApplicationContext) context)
                    .getBeanFactory();
        }
        //扫描当前 SpringBootApplication
        AnnotatedBeanDefinitionReader annotatedReader = new AnnotatedBeanDefinitionReader(registry);
        annotatedReader.register(new Class[]{ApoloApplication.class});
        ((AnnotationConfigServletWebServerApplicationContext) context).refresh();
        context.getBean(NbService.class).vo();
        User user =new User();
        user.setName("Jelly Test....");
        //context.publishEvent(new JellyEvent(user));
        context.publishEvent(new GenericJelly());
        System.out.println("123");
    }

    public void po(){
        System.out.println("opppxx");
    }
}
