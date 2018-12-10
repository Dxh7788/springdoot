package org.dano.boot.listener;

import org.dano.boot.model.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author dongxiaohong
 * @date 2018/12/10 16:54
 */
@Component
public class JellyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof PayloadApplicationEvent){
            Object o = ((PayloadApplicationEvent) event).getPayload();
            if (o instanceof User){
                dealUserEvent((User)o);
            }
        }
        System.out.println();
        if (event instanceof JellyEvent){
            System.out.println("事件执行start....");
        }
    }

    private void dealUserEvent(User user) {
        System.out.println(user.getName()+":"+user.getPassword());
    }
}
