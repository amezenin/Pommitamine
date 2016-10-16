package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        out.println("Alustame pommitamisega!");
        out.println("Autor: Anton");
        out.println("Aasta: 2016");

        int[][] lauaAlgseis = new int[9][9];
        int[][] lauaSeis = new int [9][9];

        // 0 - meri
        //1-laev
        //2 - pihta saanud laev


        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                lauaAlgseis[i][j] = (int) (Math.random()*1.03);
            }
        }



        prindiLaud(lauaAlgseis);
        System.out.println();
        prindiLaud(lauaSeis);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Kuhu tahad pommitama? Formaat: x-y");
            String input = sc.nextLine();
            String[] xy = input.split("-");
            int x = Integer.parseInt(xy[0])-1;
            int y = Integer.parseInt(xy[1])-1;


            int tabamus = lauaAlgseis[y][x];
            if (tabamus == 1) {
                lauaAlgseis[y][x] = 2;
                lauaSeis[y][x] = 2;
                System.out.println("Pihtas");
            } else if (tabamus == 0) {
                lauaSeis[y][x] = 3;
                System.out.println("Mooda");
            } else if (tabamus == 2) {
                System.out.println("Siia sa juba lasid");
            } else {
                System.out.println("error");
                break;
            }
            prindiLaud(lauaSeis);

            boolean labi = kasOnMangLabi(lauaAlgseis);
            if (labi == true){
                break;
            }

        }
        System.out.println("M'ng on l'bi");




      /*  boolean a = true;
        boolean b = false;

        int arv1 = 10;
        int arv2 = 20;

        String tulemus = arv1 < arv2 ? "True" : "Muu";
        System.out.println(tulemus);

        if (arv1 < arv2) {
            System.out.println("True");
        } else {
            System.out.println("Muu");
        }

        int arv3 = 10;
        arv3--;
        System.out.println(arv3);
        */
    }

    private static boolean kasOnMangLabi(int[][] laud) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (laud[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void prindiLaud(int [][] prinditavLaud){
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(prinditavLaud[i]));
        }

    }

    }

