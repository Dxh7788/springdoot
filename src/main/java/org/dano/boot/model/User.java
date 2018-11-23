package org.dano.boot.model;

/**
 * @author dongxiaohong on
 * @date 2018/11/22 19:33
 */
public class User {
    private String name;
    private static String password;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public static void setPassword(String pwd) {
        password = pwd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
