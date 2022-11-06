package com.example.ludemo.Figur;

public class MetodeEksempel {

    public static void main(String[] args) {
        InfoWrapper info = new InfoWrapper();
        info.navn = "sirkel";
        info.areal = 40;



        skrivUtInfo(info);
    }

    public static void skrivUtInfo(InfoWrapper info){

        System.out.println();
        System.out.println("--- --- ---");
        System.out.println();

        System.out.println("Antall: "+info.antall);
        System.out.println("Areal: "+info.areal);
        System.out.println("Navn: "+info.navn);
        System.out.println("LinjeLengde: "+info.linjelengde);

        System.out.println();
        System.out.println("--- --- ---");
        System.out.println();

    }
}
