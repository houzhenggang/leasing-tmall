package com.hshc.relay.entity;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-01 15:36
 */
public class User extends BaseEntity {

    private String name;

    private String idNumber;

    private String mobile;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
