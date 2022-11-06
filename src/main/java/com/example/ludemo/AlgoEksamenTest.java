package com.example.ludemo;

public class AlgoEksamenTest {
    public static void main(String[] args) {
        System.out.println(it3(1));
        System.out.println(it3(2));
        System.out.println(it3(3));
        System.out.println(it3(4));
        System.out.println(it3(5));
        System.out.println(it3(6));
    }

    public static int it3(int n){
        int sum = 0;
        for(int i = 0; i<n*n; i++)
            for(int j = 1; j<i; j*=2) sum++;
        return sum;
    }
}
