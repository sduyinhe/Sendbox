package com.github.sendbox;

public class test {
    public static void main(String[] args) {
        UserTest userTest = new UserTest();
        String str="111";
        System.out.println(str+(userTest.getSeatId()==null?"":userTest.getSeatId()));
    }
}
