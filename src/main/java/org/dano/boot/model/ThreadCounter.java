package org.dano.boot.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongxiaohong
 * @date 2018/12/4 14:01
 */
public class ThreadCounter implements Runnable {
    final AtomicInteger count = new AtomicInteger();
    /**
     * 同步锁volatile
     * 该值所有线程可见,当某一个线程持有的时候,其他线程必须等待获取到最新值才能继续执行.也就是说每次只能有一个线程执行
     * System.out.println(bol);
     * bol = true;
     * Thread.sleep(1000);
     */
    volatile boolean bol = false;
    @Override
    public void run() {
        count.getAndIncrement();
        if (!bol){
            try {
                bol = true;
                System.out.println("正在执行------"+Thread.currentThread().getName()+"!!!");
                bol = false;
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        /*synchronized (this){
            try {
                System.out.println("正在执行------"+Thread.currentThread().getName()+"!!!");
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("并发数量为" + count.intValue());
        }*/
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        ThreadCounter test = new ThreadCounter();
        for (int i = 0;i < 10; i++){
            pool.execute(test);
        }
    }
}
