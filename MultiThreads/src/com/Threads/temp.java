package com.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class temp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int []A;
        int []h;
        int N, K;

        N=Integer.parseInt(reader.readLine());
        A= new int[N];
        String str= reader.readLine();
        Scanner scanner= new Scanner(str);

        for(int i=0;i<N;i++){
            A[i]= scanner.nextInt();
        }

//        for (int num : A) {
//            System.out.print(num+" ");
//        }
//        System.out.println();

        K=Integer.parseInt(reader.readLine());
        h= new int[K];
        str= reader.readLine();
        Scanner scanner1= new Scanner(str);

        for (int i=0;i<K;i++){
            h[i]= scanner1.nextInt();
        }

//               for (int num : h) {
//            System.out.print(num+" ");
//        }
        int[] res= new int[K];
        for(int i=0;i<K;i++){
            for(int j=0;j<N;j++){
                if(A[j]>h[i]){
                    res[i]++;
                }
            }
        }

        for (int i=0;i<K;i++){
            System.out.print(res[i]+" ");
        }

    }
}
