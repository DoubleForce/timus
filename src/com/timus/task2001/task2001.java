package com.timus.task2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class task2001 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer reader = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        bascet bascet1 = new bascet();
        reader.nextToken();
        bascet1.firstweight = (int) reader.nval;
        bascet1.weight = bascet1.firstweight;

        bascet bascet2 = new bascet();

        reader.nextToken();
        bascet2.firstweight = (int) reader.nval;
        bascet2.weight = bascet2.firstweight;

        System.out.print(bascet1.firstweight);
        System.out.print(" ");
        System.out.print(bascet2.firstweight);

        bascet2.intersperse(bascet1);

        reader.nextToken();

        reader.nextToken();
        bascet2.mass = (int) reader.nval;

        bascet1.intersperse(bascet2);

        reader.nextToken();
        bascet1.mass = (int) reader.nval;

        reader.nextToken();

        System.out.print(bascet1.firstweight-bascet1.mass);
        System.out.print(" ");
        System.out.print(bascet2.firstweight-bascet2.mass);
    }
    
    public static class bascet{
        public int firstweight;
        public int weight;
        public int mass;

        public bascet(){

        }

        public void intersperse(bascet bascetName){
            bascetName.weight += dif(weight,mass);
            weight = mass;
        }

        public int dif(int a, int b){
            return Math.abs(a-b);
        }
    }
}
