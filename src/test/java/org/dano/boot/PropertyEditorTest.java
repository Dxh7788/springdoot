package org.dano.boot;

import org.dano.boot.model.User;
import org.junit.Test;

import java.beans.PropertyEditorSupport;

/**
 * @author dongxiaohong on
 * @date 2018/11/23 16:58
 */
public class PropertyEditorTest {

    public static class UserPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text!=null){
                String[] params = text.split(":");
                if (params.length >=3){
                    User user = new User();
                    user.setName(params[0]);
                    user.setPassword(params[1]);
                    user.setAge(Integer.decode(params[2]));
                    this.setValue(user);
                    return;
                }
            }
            this.setValue(null);
        }
    }

    @Test
    public void userPropertyEditorTest(){
        UserPropertyEditor editor = new UserPropertyEditor();
        editor.setAsText("dxh:123456:20");
        Object o = editor.getValue();
        if (o instanceof User){
            User user = (User)o;
            System.out.println("name:"+user.getName()+",password:"+user.getPassword()+",age:"+user.getAge());
        }
    }
}
