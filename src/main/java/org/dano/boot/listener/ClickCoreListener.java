package org.dano.boot.listener;

import org.dano.boot.listener.event.ClickEvent;

/**
 * @author dongxiaohong
 * @date 2018/12/11 13:51
 */
public class ClickCoreListener implements CoreListener {
    @Override
    public void dealEvent(CoreEvent event) {
        if (event instanceof ClickEvent){
            System.out.println("点击事件触发....");
        }
    }
}
