package com.apple.developer.entity;

public class PetStore {
    private int ps_id;
    private String ps_name;

    public PetStore() {
    }

    public PetStore(String ps_name) {
        this.ps_name = ps_name;
    }

    public PetStore(int ps_id, String ps_name) {
        this.ps_id = ps_id;
        this.ps_name = ps_name;
    }

    public int getPs_id() {
        return ps_id;
    }

    public void setPs_id(int ps_id) {
        this.ps_id = ps_id;
    }

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }

    @Override
    public String toString() {
        return "宠物商店--->宠物店编号："+ps_id+"\t宠物店名字："+ps_name;
//        return "PetStore{" +
//                "ps_id=" + ps_id +
//                ", ps_name='" + ps_name + '\'' +
//                '}';
    }
}
