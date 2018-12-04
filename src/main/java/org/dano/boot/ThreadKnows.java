package org.dano.boot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongxiaohong
 * @date 2018/12/4 14:19
 */
public class ThreadKnows {

    static class DiaoThread implements Runnable{
        /**
         * 共享变量 bol
         * */
        volatile boolean bol;
        @Override
        public void run() {
            if (!bol){
                try {
                    //进入时锁住
                    bol = true;
                    System.out.println(Thread.currentThread().getName());
                    //执行完成释放,如果不释放则其他线程无法执行
                    bol =false;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 顺序执行10个线程
     */
    public static void sequenceExes(){
        ExecutorService pool = Executors.newCachedThreadPool();
        DiaoThread thread = new DiaoThread();
        for (int i = 0; i!=10 ; i++){
            pool.execute(thread);
        }
    }

    public static void main(String[] args) {
        sequenceExes();
    }
}
