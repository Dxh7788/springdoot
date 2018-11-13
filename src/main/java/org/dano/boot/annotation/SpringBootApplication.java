package org.dano.boot.annotation;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * @author dongxiaohong on 2018/11/13 10:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan
@SpringBootConfiguration
public @interface SpringBootApplication {
}
