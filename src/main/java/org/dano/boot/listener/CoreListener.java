package org.dano.boot.listener;

/**
 * @author dongxiaohong
 * @date 2018/12/11 09:44
 */
public interface CoreListener {
    /**
     * 处理事件
     * @param event
     * */
    void dealEvent(CoreEvent event);
}
