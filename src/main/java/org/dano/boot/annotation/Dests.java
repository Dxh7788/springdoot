package org.dano.boot.annotation;

import java.lang.annotation.*;

/**
 * @author dongxiaohong
 * @date 2018/12/5 19:42
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dests {
    Dest[] value();
}
