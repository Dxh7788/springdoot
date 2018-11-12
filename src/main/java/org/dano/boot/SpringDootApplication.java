package org.dano.boot;

/**
 * @author dongxiaohong on 2018/11/12 14:10
 */
public class SpringDootApplication {

    public void run(){
        String basePackage = this.getClass().getPackage().getName();
        System.out.println(basePackage);
        //自动扫描包
    }
}
