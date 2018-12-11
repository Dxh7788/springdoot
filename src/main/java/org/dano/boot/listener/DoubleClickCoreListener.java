package org.dano.boot.listener;

import org.dano.boot.listener.event.DoubleClickEvent;

/**
 * @author dongxiaohong
 * @date 2018/12/11 13:52
 */
public class DoubleClickCoreListener implements CoreListener {
    @Override
    public void dealEvent(CoreEvent event) {
        if (event instanceof DoubleClickEvent){
            System.out.println("双击事件触发....");
        }
    }
}
