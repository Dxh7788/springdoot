package org.dano.boot.annotation;

import java.lang.annotation.*;

/**
 * @author dongxiaohong
 * @date 2018/12/6 15:08
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Destss {
    Dests[] value();
}
