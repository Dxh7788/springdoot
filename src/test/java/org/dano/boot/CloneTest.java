package org.dano.boot;

import org.dano.boot.model.CloneUser;
import org.junit.Test;

/**
 * @author dongxiaohong on
 * @date 2018/11/26 09:27
 */
public class CloneTest {
    @Test
    public void objectCloneTest(){
        try {
            CloneUser user = new CloneUser().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
