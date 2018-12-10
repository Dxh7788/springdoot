package org.dano.boot.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author dongxiaohong
 * @date 2018/12/10 16:54
 */
public class JellyEvent extends ApplicationEvent {
    public JellyEvent(Object source) {
        super(source);
    }
}
