package org.dano.boot.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongxiaohong
 * @date 2018/12/4 15:03
 */
public class JavaVolatile {


    public volatile int inc ;

    public synchronized void inc(){
        inc++;
    }

    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false,false);
        for (ThreadInfo info:threadInfos){
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }

        final JavaVolatile javaVolatile = new JavaVolatile();
        for (int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int j=0; j<1000 ;j++){
                        javaVolatile.inc();
                    }
                }
            }.start();
        }
        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(javaVolatile.inc);
    }
}
