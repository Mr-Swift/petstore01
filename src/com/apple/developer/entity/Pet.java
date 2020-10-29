package com.apple.developer.entity;

import java.awt.*;
import java.io.Serializable;

public class Pet implements Serializable {
    private int p_id;
    private String p_name;
    private int health;
    private String birthday;
    private String address;

    public Pet() {
    }

    public Pet(String p_name, int health, String birthday, String address) {
        this.p_name = p_name;
        this.health = health;
        this.birthday = birthday;
        this.address = address;
    }

    public Pet(int p_id, String p_name, int health, String birthday, String address) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.health = health;
        this.birthday = birthday;
        this.address = address;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "宠物--->宠物编号："+p_id+"\t宠物名字："+p_name+"\t健康值:"+health+"\t生日："+birthday+"\t地址："+address;
//        return "Pet{" +
//                "p_id=" + p_id +
//                ", p_name='" + p_name + '\'' +
//                ", health=" + health +
//                ", birthday='" + birthday + '\'' +
//                ", address='" + address + '\'' +
//                '}';
    }
}
