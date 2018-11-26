package org.dano.boot.model;

/**
 * @author dongxiaohong on
 * @date 2018/11/22 19:33
 */
public class CloneUser implements Cloneable{

    @Override
    public CloneUser clone() throws CloneNotSupportedException {
        return new CloneUser();
    }
}
