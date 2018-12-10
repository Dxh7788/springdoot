package org.dano.boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author dongxiaohong
 * @date 2018/12/10 16:54
 */
@Component
public class JellyListener implements SmartApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof PayloadApplicationEvent){
            Object o = ((PayloadApplicationEvent) event).getPayload();
            if (o instanceof GenericJelly){
                dealGenericJellyEvent((GenericJelly)o);
            }
        }
        System.out.println();
        if (event instanceof JellyEvent){
            System.out.println("事件执行start....");
        }
    }

    private void dealGenericJellyEvent(GenericJelly gj) {
        System.out.println("执行处GenericJelly....");
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return true;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
