package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Third {
    public static void main(String[] args) throws IOException {

        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        long N,X;
        int count=0;

        N=Long.parseLong(reader.readLine());

        while (N%10==0){
            N=N/10;
        }
        X=N;

        while (X>=10){
            if(X%10==0){
                count++;
            }
            X=X/10;
        }

        System.out.println(count);

    }
}
