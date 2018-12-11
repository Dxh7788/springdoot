package org.dano.boot.listener;

import org.dano.boot.listener.event.CommitEvent;

/**
 * @author dongxiaohong
 * @date 2018/12/11 13:48
 */
public class CommitCoreListener implements CoreListener {
    @Override
    public void dealEvent(CoreEvent event) {
        if (event instanceof CommitEvent){
            System.out.println("Commit 事件触发了....");
        }
    }
}
