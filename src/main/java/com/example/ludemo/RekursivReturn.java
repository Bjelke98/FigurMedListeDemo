package com.example.ludemo;

public class RekursivReturn {
    public static void main(String[] args) {
        System.out.println(potens2(16));
    }
    public static int potens2(int antall){
        if(antall<=1)return 1;
        return potens2(antall-1)+potens2(antall-1);
    }
}
