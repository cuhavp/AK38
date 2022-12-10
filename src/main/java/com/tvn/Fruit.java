package com.tvn;

public class Fruit {
    protected String color;


    public Fruit(String color) {
        this.color = color;
    }

    void info(){
        System.out.println(this.color);
    }
}
