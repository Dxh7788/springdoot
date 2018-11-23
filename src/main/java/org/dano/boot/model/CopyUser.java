package org.dano.boot.model;

/**
 * @author dongxiaohong on
 * @date 2018/11/22 19:33
 */
public class CopyUser {
    private String name;
    private String password;
    private CopyUser user;

    public String getName() {
        return name;
    }

    public CopyUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CopyUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public CopyUser getUser() {
        return user;
    }

    public CopyUser setUser(CopyUser user) {
        this.user = user;
        return this;
    }
}
