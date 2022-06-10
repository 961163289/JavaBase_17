package com.hspedu;

public class Cat {
    public String name = "小黄";
    private int age = 3;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
//        System.out.println("hi() 方法");
    }

    public void cry() {
        System.out.println("cry() 方法");
    }
}
