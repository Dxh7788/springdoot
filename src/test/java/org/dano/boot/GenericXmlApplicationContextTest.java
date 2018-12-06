package org.dano.boot;

import org.dano.boot.service.NbService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dongxiaohong
 * @date 2018/11/16 17:05
 */
public class GenericXmlApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-test.xml");

        for (String beanName:context.getBeanDefinitionNames()){
            System.out.println(beanName);
        }
        NbService nbService = (NbService) context.getBean("nbService");
        nbService.vo();
    }
}
