package com.lei.mycode;

import java.math.BigInteger;

import static com.lei.mycode.Json.record_uri;

//public class myclasstest {
//    public static void main(String[] args) {
//        Student s = new Student("雷镇豪", 23, 89);
//        System.out.println(s.score);
//    }
//}

public class myclasstest {
    protected String name;
    protected int age;
    public myclasstest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends myclasstest {
    protected int score;

    public Student(String name, int age, int score) {
        super(name,age);
        this.score = score;
    }
}
