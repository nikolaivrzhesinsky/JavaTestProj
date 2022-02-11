package com.Threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {



    public static void main(String args[] ) throws Exception {
       
        int N, sum = 0;
        int[] array;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(reader.readLine());
        array= new int[N];

        for(int i=0; i<N;i++){
            array[i]=Integer.parseInt(reader.readLine());
        }

        for(int i=0;i<N;i++){
            for(int j=array[i]-1;j>=1;j--){
                if(array[i]%j==0){
                    sum+=j;
                }
            }
            if(array[i]==sum){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            sum=0;
        }


    }
}