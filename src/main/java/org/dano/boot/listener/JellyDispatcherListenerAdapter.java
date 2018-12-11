package org.dano.boot.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongxiaohong
 * @date 2018/12/11 09:43
 */
public class JellyDispatcherListenerAdapter {

    //注册的监听器
    private List<CoreListener> coreListeners;

    public JellyDispatcherListenerAdapter() {
        coreListeners = new ArrayList<>(0);
    }

    public void addListeners(CoreListener listener){
        coreListeners.add(listener);
    }

    public void publishEvent(CoreEvent event){
        for (CoreListener listener:coreListeners){
            //TODO 要加一个分析判断判断是否是需要处理的event
            listener.dealEvent(event);
        }
    }
}
