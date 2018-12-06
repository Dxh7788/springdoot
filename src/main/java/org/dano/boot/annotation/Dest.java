package org.dano.boot.annotation;


import java.lang.annotation.*;

/**
 * @author dongxiaohong
 * @date 2018/12/5 19:41
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(Dests.class)
public @interface Dest {
    String value() default "";
}
