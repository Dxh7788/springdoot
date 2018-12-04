package org.dano.boot.thread;

/**
 * @author dongxiaohong
 * @date 2018/12/4 15:03
 */
public class JavaVolatile {

    public volatile int inc = 0;

    public void inc(){
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
        System.out.println(javaVolatile.inc);
    }
}
