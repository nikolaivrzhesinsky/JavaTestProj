package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class first {
    public static void main(String[] args) throws IOException {
        int A,B,N;
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

            A= Integer.parseInt(reader.readLine());
            B= Integer.parseInt(reader.readLine());
            N= Integer.parseInt(reader.readLine());

            reader.close();

            int min=(int)Math.ceil((double) B/N);
            if(A>min){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
    }
}
