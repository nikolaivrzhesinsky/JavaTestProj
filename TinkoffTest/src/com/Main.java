package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {

        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try{
            int num1= Integer.parseInt(reader.readLine());
            int num2= Integer.parseInt(reader.readLine());
            System.out.println(num1+num2);
            reader.close();
        }
        catch (IOException e){

            System.out.println(e.getMessage());
        }

    }
}
