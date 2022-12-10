package com.tvn;

import java.util.Random;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int math;
    private int chemistry;
    private int physics;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.id = new Random().nextInt();
    }
    public Student(){}

    public void info(){
        System.out.println("Student Id: "+this.id);
        System.out.println("Student total points: "+total());
    }
    public void setMath(int math) {
        this.math = math;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int total(){
        return this.chemistry+this.math+this.physics;
    }
}
