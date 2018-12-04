package org.dano.boot.thread;

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
        /*while (Thread.activeCount()>1){
            Thread.yield();
        }*/
        System.out.println(javaVolatile.inc);
    }
}
