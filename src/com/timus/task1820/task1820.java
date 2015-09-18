package com.timus.task1820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class task1820 {
    public static void main(String[] args) throws Exception
    {
        StreamTokenizer reader = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        reader.nextToken();
        int n = (int)reader.nval;
        reader.nextToken();
        int k = (int)reader.nval;

        if(n == 0)
            System.out.print(n);
        else if (k > n)
            System.out.println(2);
        else
            System.out.print((int)Math.ceil(2*(float)n/(float)k));
    }
}
