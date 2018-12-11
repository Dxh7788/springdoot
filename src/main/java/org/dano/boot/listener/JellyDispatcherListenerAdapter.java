package org.dano.boot.listener;

import org.dano.boot.listener.event.ClickEvent;
import org.dano.boot.listener.event.CommitEvent;
import org.dano.boot.listener.event.DoubleClickEvent;

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

    public static void main(String[] args) {
        JellyDispatcherListenerAdapter adapter = new JellyDispatcherListenerAdapter();
        adapter.addListeners(new CommitCoreListener());
        adapter.addListeners(new ClickCoreListener());
        adapter.addListeners(new DoubleClickCoreListener());
        adapter.publishEvent(new CommitEvent());
        adapter.publishEvent(new ClickEvent());
        adapter.publishEvent(new DoubleClickEvent());
    }
}
